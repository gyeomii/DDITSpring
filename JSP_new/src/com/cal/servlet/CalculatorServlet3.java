package com.cal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator3")
public class CalculatorServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "calculator3.jsp";

		request.setAttribute("result", "");
		request.setAttribute("sik", "");
		request.setAttribute("operator", "");

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "calculator3.jsp";
		String sik = request.getParameter("sik");
		String firstNum = request.getParameter("firstNum");
		String operator = request.getParameter("operator");
		
		String[] strArr = firstNum.split(",");
		String[] opArr = operator.split(",");
		ArrayList<Double> numList = new ArrayList<Double>();
		
		for (String string : strArr) {
			Double num = Double.parseDouble(string);
			numList.add(num);			
		}
		
		for(int i = 0; i < opArr.length; i++) {
			Double result = 0.0;
			if(opArr[i].equals("*")) {
				Double num1 = numList.get(i);
				Double num2 = numList.get(i+1);
				result = num1 * num2;
				numList.set(i, 0.0);
				numList.set(i+1, result);
			}else if(opArr[i].equals("/")) {
				Double num1 = numList.get(i);
				Double num2 = numList.get(i+1);
				result = num1 / num2;
				numList.set(i, 0.0);
				numList.set(i+1, result);
			}
		}
		
		ArrayList<String> opList = new ArrayList<String>();
		for (String string : opArr) {
			opList.add(string);
		}
		
		while(opList.remove("*")) {}
		while(opList.remove("/")) {}
		while(numList.remove(Double.valueOf(0.0))) {}
		
		int idx = 0;
		for (String oper : opList) {
			Double result = 0.0;
			if(oper.equals("+")) {
				Double num1 = numList.get(idx);
				Double num2 = numList.get(idx+1);
				result = num1 + num2;
				numList.set(idx, 0.0);
				numList.set(idx+1, result);
			}else if(oper.equals("-")) {
				Double num1 = numList.get(idx);
				Double num2 = numList.get(idx+1);
				result = num1 - num2;
				numList.set(idx, 0.0);
				numList.set(idx+1, result);
			}
			idx++;
		}
		
		Double res = 0.0;
		for (Double double1 : numList) {
			res += double1;
		}
		
		request.setAttribute("operator", "");
		request.setAttribute("result", res);
		request.setAttribute("sik", sik);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
//0.0 * 72.0 - 6.0 + 0.0 / 1.0 + 2.0 
// * - + / +