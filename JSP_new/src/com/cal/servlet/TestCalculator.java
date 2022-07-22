package com.cal.servlet;

import java.util.Scanner;

import com.cal.service.Operator;
import com.cal.service.OperatorImpl;

public class TestCalculator {

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 숫자 >>");
			double firstNum = Double.parseDouble(scan.nextLine());
			System.out.print("연산자 >>");
			String operator = scan.nextLine();
			System.out.print("두번째 숫자 >>");
			double secondNum = Double.parseDouble(scan.nextLine());

			Operator operatorImpl = OperatorImpl.getInstance();
			Number result = operatorImpl.operator(firstNum, secondNum, operator);
			System.out.println(result);
		}
	}
}