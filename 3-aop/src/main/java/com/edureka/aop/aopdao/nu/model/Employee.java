package com.edureka.aop.aopdao.nu.model;

import lombok.Data;

@Data
public class Employee {
	private String name;
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}
}
