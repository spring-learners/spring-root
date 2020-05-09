package com.edureka.aop.aopdao.demo1;

import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Data
public class EmployeeAspect {

    boolean beforeCalled=false;

    @Before(value = "execution(* com.edureka.spring.aop.Employee.m1())")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());
        beforeCalled = true;
    }
}
