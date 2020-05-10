package com.edureka.aop.aopdao.nu.main;

import com.edureka.spring.aop.nu.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		System.out.println(employeeService.getEmployee().getName());
		employeeService.getEmployee().setName("Pankaj");
		employeeService.getEmployee().throwException();
		ctx.close();
	}

}
