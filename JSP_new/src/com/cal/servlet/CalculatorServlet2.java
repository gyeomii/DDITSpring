package com.cal.servlet;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.service.Operator;
import com.cal.service.OperatorImpl;

@WebServlet("/calculator2")
public class CalculatorServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/calculator2.jsp";
		request.setAttribute("result", "0");
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/calculator2.jsp";

		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		String operator = request.getParameter("operator");
		double secondNum = Double.parseDouble(request.getParameter("secondNum"));

		Operator operatorImpl = OperatorImpl.getInstance();
		Number result = operatorImpl.operator(firstNum, secondNum, operator);

		request.setAttribute("result", result);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
