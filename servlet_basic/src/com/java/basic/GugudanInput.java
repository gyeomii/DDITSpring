package com.java.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GugudanInput implements Input {

	@Override
	public Map<String, Integer> execute() {
		
		Map<String, Integer> data = new HashMap<String,Integer>();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("단수를 입력하세요 : ");
		data.put("dan", Integer.parseInt(scan.nextLine()));		
		
		System.out.print("곱수를 입력하세요 : ");
		data.put("gop", Integer.parseInt(scan.nextLine()));
		scan.close();
		return data;
	}

}
