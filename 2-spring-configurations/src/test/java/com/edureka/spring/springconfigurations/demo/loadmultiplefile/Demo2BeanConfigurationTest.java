package com.edureka.spring.springconfigurations.demo.loadmultiplefile;

import com.edureka.spring.springconfigurations.demo2.beanconfiguration.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2BeanConfigurationTest {

    @Test
    public void shouldLoadAllChildConfiguration(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2-parent.xml");
        A a = applicationContext.getBean(A.class);
        B b = applicationContext.getBean(B.class);
        Assertions.assertThat(a).isNotNull();
        Assertions.assertThat(b).isNotNull();
    }

    @Test
    public void shouldAutoWireAndShowValueWithAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2-annotation.xml");
        C c = applicationContext.getBean(C.class);

        Assertions.assertThat(c).isNotNull();
        Assertions.assertThat(c.getD()).isNotNull();

        Assertions.assertThat(c.getStringValue()).isEqualTo("string value");
    }

    @Test
    public void shouldTestLifeCycleWithAnnovation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2-annotation.xml");
        LifeCycleBean lcb = applicationContext.getBean(LifeCycleBean.class);
        ((AbstractApplicationContext)applicationContext).registerShutdownHook();
        lcb.m1();

        Assertions.assertThat(lcb).isNotNull();
        Assertions.assertThat(lcb.isPostConstructCalled()).isTrue();
        //Assertions.assertThat(lcb.isPreDestroyCalled()).isTrue();

    }

    @Test
    public void shouldLoadAutoDiscoveryBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.edureka.spring.springconfigurations.demo2.beanconfiguration");
        SelfDiscoveredBean sdb = applicationContext.getBean(SelfDiscoveredBean.class);
        ((AbstractApplicationContext)applicationContext).registerShutdownHook();
        Assertions.assertThat(sdb).isNotNull();
        Assertions.assertThat(sdb.getServerPort()).isEqualTo(8080);
    }
}
