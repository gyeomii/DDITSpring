package com.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceBehavior {
	public void chika() {
		System.out.println("***치카***");
	}
	
	//joinpoint : around
	public void chikaAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("***칰1***");
		
		joinPoint.proceed();
		
		System.out.println("***칰2***");
	}
}
