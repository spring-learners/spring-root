package com.edureka.aop.aopdao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class ForLogging {
	
	@Before("execution (* com.edureka.aop.aopdao.TargetBean.m1())")
	public void logBefore(JoinPoint joinPoint){
		System.out.println("In the logBefore method of ForLogging Aspect");
		System.out.println("Intercepted the call to "+joinPoint.getSignature().getName());
	}

}
