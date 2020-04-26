package com.edureka.spring.introductionofspring.demo;

import com.edureka.spring.introductionofspring.demo2.beandefiitionandscope.Country;
import com.edureka.spring.introductionofspring.demo2.beandefiitionandscope.LifecycleBean;
import com.edureka.spring.introductionofspring.demo2.beandefiitionandscope.LifecycleBeanWithInterfaces;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Demo2BeanScopeAndLifeCycleTest {

    @Test
    public void shouldInjectAnInnerBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2.xml");
        Country country = applicationContext.getBean("country_with_bean_scope", Country.class);
        Assertions.assertThat(country.getState()).isNotNull();
    }

    @Test
    public void shouldTestAnAlias(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2.xml");
        Country country = applicationContext.getBean("country_with_bean_scope_alias", Country.class);
        Assertions.assertThat(country.getState()).isNotNull();
    }

    @Test
    public void shouldTestLifeCycleWithXMLDefinition(){
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2.xml");
        LifecycleBean lifecycleBean = applicationContext.getBean("lifeCycleBeanWithXML", LifecycleBean.class);
        lifecycleBean.m1();
        applicationContext.registerShutdownHook();
        Assertions.assertThat(lifecycleBean.isInitCalled()).isTrue();
        Assertions.assertThat(lifecycleBean.isDestroyCalled()).isFalse();
    }

    @Test
    public void shouldTestLifeCycleWithInterfaceDefinition(){
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo2.xml");
        LifecycleBeanWithInterfaces lifecycleBean = applicationContext.getBean("lifeCycleBeanWithInterfaces", LifecycleBeanWithInterfaces.class);
        lifecycleBean.m1();
        applicationContext.registerShutdownHook();
        Assertions.assertThat(lifecycleBean.isInitCalled()).isTrue();
        Assertions.assertThat(lifecycleBean.isDestroyCalled()).isFalse();
    }

}