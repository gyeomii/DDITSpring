package com.java.basic;

public class GugudanOutput implements Output {

	@Override
	public void print() {
		System.out.println();
	}

	@Override
	public void print(int dan) {
		System.out.println(dan + "단");
	}

	@Override
	public void print(int dan, int gop) {
		System.out.println(dan + " * " + gop + " = " + dan * gop);
	}
	
}
