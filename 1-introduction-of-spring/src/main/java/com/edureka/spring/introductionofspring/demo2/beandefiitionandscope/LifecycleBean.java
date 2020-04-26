package com.edureka.spring.introductionofspring.demo2.beandefiitionandscope;

import lombok.Data;

@Data
public class LifecycleBean {

    boolean initCalled, destroyCalled;

    public void init(){
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
