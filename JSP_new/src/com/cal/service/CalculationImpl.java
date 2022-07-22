package com.cal.service;

public class CalculationImpl implements Calculation {

	static Calculation calculationImpl = new CalculationImpl();
	ProcessedAndCutDecimal processedAndCutDecimal = ProcessedAndCutDecimalImpl.getInstance();

	private CalculationImpl() {
	}

	public static Calculation getInstance() {
		return calculationImpl;
	}

	@Override
	public Number add(double firstNum, double secondNum) {
		return processedAndCutDecimal.processed(firstNum + secondNum);
	}

	@Override
	public Number subtract(double firstNum, double secondNum) {
		return processedAndCutDecimal.processed(firstNum - secondNum);
	}

	@Override
	public Number multiply(double firstNum, double secondNum) {
		return processedAndCutDecimal.processed(firstNum * secondNum);
	}

	@Override
	public Number divide(double firstNum, double secondNum) {
		if ((double) secondNum == 0.0) {
			return 0;
		} else {
			return processedAndCutDecimal.processed(firstNum / secondNum);
		}
	}
}
