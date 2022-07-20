package com.cal.servlet;

import java.util.Map;

public interface Operator {
	public Map<String, String> split(String str);
	
	public int operator(int firstNum, int secondNum, String operator);

	public int add(int firstNum, int secondNum);

	public int subtract(int firstNum, int secondNum);

	public int multiply(int firstNum, int secondNum);

	public int divide(int firstNum, int secondNum);
}
