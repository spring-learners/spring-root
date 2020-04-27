package com.edureka.spring.springconfigurations.demo1.autowiring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class Demo1AutowiringTest {

    @Test
    public void shouldAutoWireByName(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Company company = applicationContext.getBean("companyWithByName",Company.class);
        Assertions.assertThat(company.getEmployee()).isNotNull();
    }

    @Test
    public void shouldAutoWireByType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Company company = applicationContext.getBean("companyWithByType",Company.class);
        Assertions.assertThat(company.getEmployee()).isNotNull();
    }

    @Test
    public void shouldAutoWireByConstructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Company company = applicationContext.getBean("companyWithByConstructor",Company.class);
        Assertions.assertThat(company.getEmployee()).isNotNull();
    }

}