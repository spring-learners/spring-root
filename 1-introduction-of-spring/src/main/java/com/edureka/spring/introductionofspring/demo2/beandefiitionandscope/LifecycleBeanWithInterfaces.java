package com.edureka.spring.introductionofspring.demo2.beandefiitionandscope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Data
public class LifecycleBeanWithInterfaces implements InitializingBean, DisposableBean {

    boolean initCalled, destroyCalled;

    @Override
    public void afterPropertiesSet() throws Exception {
        initCalled = true;
        System.out.println("Initializing ...");
    }


    public void m1(){
        System.out.println("Inside m1");
    }

    public void destroy(){
        if (initCalled){
            destroyCalled = true;
        }
        System.out.println("Destroying ...");
    }



}
