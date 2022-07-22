package com.cal.service;

public class OperatorImpl implements Operator {

	static Operator operator = new OperatorImpl();

	private OperatorImpl() {
	}

	public static Operator getInstance() {
		return operator;
	}

	@Override
	public Number operator(double firstNum, double secondNum, String operator) {
		Number processedNumber = 0;
		
		Calculation calculation = CalculationImpl.getInstance();
		
		switch (operator) {
		case "+":
			processedNumber = calculation.add(firstNum, secondNum);
			break;
		case "-":
			processedNumber = calculation.subtract(firstNum, secondNum);
			break;
		case "*":
			processedNumber = calculation.multiply(firstNum, secondNum);
			break;
		case "/":
			processedNumber = calculation.divide(firstNum, secondNum);
			break;
		}
		
		return processedNumber;
		
	}
}
