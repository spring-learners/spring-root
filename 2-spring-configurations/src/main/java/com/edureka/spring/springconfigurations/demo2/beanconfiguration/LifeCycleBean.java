package com.edureka.spring.springconfigurations.demo2.beanconfiguration;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Data
public class LifeCycleBean {

    List<String> databases;

    boolean postConstructCalled = false;
    boolean preDestroyCalled = false;

    @PostConstruct
    public void populateMovies(){
        databases=new ArrayList<String>();
        databases.add("SQL");
        databases.add("Cassandra");

        postConstructCalled = true;
    }

   public void m1(){
        System.out.println("Some out put");
   }

    @PreDestroy
    public void clearMovies(){
        if(postConstructCalled){
            preDestroyCalled = true;
        }
        databases.clear();
    }
}
