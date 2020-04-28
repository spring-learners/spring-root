package com.edureka.aop.aopdao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MethodBeforeAdvisorTest {

    @Test
    public void shouldTestMethodBeforeAdvisor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TargetBean obj=(TargetBean)context.getBean("proxy");
        MethodBeforeAdvisor methodBeforeAdvisor = context.getBean("beforeAdvisor", MethodBeforeAdvisor.class);
        obj.m1();
        Assertions.assertThat(methodBeforeAdvisor.getMethodBeforeCalled()).isTrue();
    }

    @Test
    public void shouldTestLogginAspect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TargetBean obj=(TargetBean)context.getBean("targetBean");
        obj.m1();

    }

}