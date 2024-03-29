package com.spring.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.cal.Calculator;

public class Main {
	public static void main(String[] args) {
		//Calculator cal = new Calculator();
		
		//xml을 읽어서 application context 컨테이너를 만들어주는 
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/spring/context/application-context.xml");
		
		// bean에서 cal을 꺼내서 같은타입인지 검증
		Calculator cal = ctx.getBean("cal", Calculator.class);
		
		int a = 10;
		int b = 5;
		System.out.println(a + " + " + b + " = " + cal.sum(a, b));
		System.out.println(a + " - " + b + " = " + cal.minus(a, b));
		System.out.println(a + " * " + b + " = " + cal.multi(a, b));
		System.out.println(a + " / " + b + " = " + cal.div(a, b));
	}
}
