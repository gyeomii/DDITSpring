package com.java.basic;

import java.util.Map;

public class GugudanService implements Service {

	private Input input;
	private Output output;

	public void setInput(Input input) {
		this.input = input;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	@Override
	public void process() {
		Map<String, Integer> data = input.execute();
		int danNum = data.get("dan");
		int gopNum = data.get("gop");

		output.print();
		for (int dan = 2; dan <= danNum; dan++) {
			output.print(dan);
			// 곱수반복
			for (int gop = 1; gop <= gopNum; gop++) {
				output.print(dan, gop);
			}
			output.print();
		}
	}
	
}
