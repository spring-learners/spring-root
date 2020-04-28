package com.edureka.aop.aopdao;

import lombok.Data;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Data
public class MethodBeforeAdvisor implements MethodBeforeAdvice {

	Boolean methodBeforeCalled;

	@Override
	public void before(Method method, Object[] arg, Object arg2)
			throws Throwable {
		methodBeforeCalled = true;
	}
	
	
}
