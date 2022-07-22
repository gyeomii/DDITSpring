package com.cal.service;

import java.text.NumberFormat;

public class ProcessedAndCutDecimalImpl implements ProcessedAndCutDecimal{
	
	static ProcessedAndCutDecimal processedAndCutDecimal = new ProcessedAndCutDecimalImpl();

	private ProcessedAndCutDecimalImpl() {
	}

	public static ProcessedAndCutDecimal getInstance() {
		return processedAndCutDecimal;
	}
	
	public Number processed(double processedNumber) {
		if (processedNumber % 1 == 0) {
			return (long) processedNumber;
		} else {
			return cutDecimal(4, processedNumber);
		}
	}

	public double cutDecimal(int cutSize, double value) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(cutSize);
		nf.setGroupingUsed(false);

		return Double.parseDouble(nf.format(value));
	}
}
