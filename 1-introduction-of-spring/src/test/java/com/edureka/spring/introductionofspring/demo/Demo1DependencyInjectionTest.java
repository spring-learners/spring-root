package com.edureka.spring.introductionofspring.demo;

import com.edureka.spring.introductionofspring.demo1.di.Company;
import com.edureka.spring.introductionofspring.demo1.di.Database;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Demo1DependencyInjectionTest {

    @Test
    public void shouldDIUsingSetter(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo1.xml");
        Company company = applicationContext.getBean("companyWithSetter",Company.class);
        Assertions.assertThat(company.getEmployee()).isNotNull();
    }

    @Test
    public void shouldDIUsingConstructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo1.xml");
        Company company = applicationContext.getBean("companyWithConstructor", Company.class);
        Assertions.assertThat(company.getEmployee()).isNotNull();
    }

    @Test
    public void shouldPopulateAList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-demo1.xml");
        Database database = applicationContext.getBean("database", Database.class);
        Assertions.assertThat(database.getNoSqls().size()).isEqualTo(3);
    }

}