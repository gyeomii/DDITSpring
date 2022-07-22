package com.cal.servlet;

public interface Operator {

	public Number operator(double firstNum, double secondNum, String operator);

	public double add(double firstNum, double secondNum);

	public double subtract(double firstNum, double secondNum);

	public double multiply(double firstNum, double secondNum);

	public double divide(double firstNum, double secondNum);
}
