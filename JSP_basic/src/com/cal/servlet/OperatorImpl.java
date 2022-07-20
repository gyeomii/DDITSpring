package com.cal.servlet;

import java.util.HashMap;
import java.util.Map;

public class OperatorImpl implements Operator {

	static Operator operator = new OperatorImpl();

	private OperatorImpl() {
	}

	public static Operator getInstance() {
		return operator;
	}
	@Override
	public Map<String, String> split(String str) {
		Map<String, String> map = new HashMap<String, String>();
		String firstNum = str.substring(0, 1);
		String secondNum = str.substring(3, 4);
		String operator = str.substring(2, 2);
		map.put("firstNum", firstNum);
		map.put("secondNum", secondNum);
		map.put("operator", operator);
		return map;
	}
	
	@Override
	public int operator(int firstNum, int secondNum, String operator) {
		int result = 0;
		switch (operator) {
		case "+":
			result = add(firstNum, secondNum);
			break;
		case "-":
			result = subtract(firstNum, secondNum);
			break;
		case "*":
			result = multiply(firstNum, secondNum);
			break;
		case "/":
			result = divide(firstNum, secondNum);
			break;
		}
		return result;
	}

	@Override
	public int add(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

	@Override
	public int subtract(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}

	@Override
	public int multiply(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

	@Override
	public int divide(int firstNum, int secondNum) {
		return firstNum / secondNum;
	}
}
