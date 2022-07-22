package com.cal.servlet;

import java.text.NumberFormat;

public class OperatorImpl implements Operator {

	static Operator operator = new OperatorImpl();

	private OperatorImpl() {
	}

	public static Operator getInstance() {
		return operator;
	}

	@Override
	public Number operator(double firstNum, double secondNum, String operator) {
		double processedNumber = 0;
		switch (operator) {
		case "+":
			processedNumber = add(firstNum, secondNum);
			break;
		case "-":
			processedNumber = subtract(firstNum, secondNum);
			break;
		case "*":
			processedNumber = multiply(firstNum, secondNum);
			break;
		case "/":
			processedNumber = divide(firstNum, secondNum);
			break;
		}
		// "0이하의 소수점이 없을경우"
		if (processedNumber % 1 == 0) {
			return (int) processedNumber;
		} else {
			return cutDecimal(4, processedNumber);
		}
	}

	public static double cutDecimal(int cutSize, double value) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(cutSize);
		nf.setGroupingUsed(false);

		return Double.parseDouble(nf.format(value));
	}

	@Override
	public double add(double firstNum, double secondNum) {
		return firstNum + secondNum;
	}

	@Override
	public double subtract(double firstNum, double secondNum) {
		return firstNum - secondNum;
	}

	@Override
	public double multiply(double firstNum, double secondNum) {
		return firstNum * secondNum;
	}

	@Override
	public double divide(double firstNum, double secondNum) {
		if ((int) secondNum == 0) {
			return 0;
		} else {
			return firstNum / secondNum;
		}
	}
}
