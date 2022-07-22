package com.cal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.service.ProcessedAndCutDecimal;
import com.cal.service.ProcessedAndCutDecimalImpl;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/calculator.jsp";

		request.setAttribute("result", "");
		request.setAttribute("formula", "");
		request.setAttribute("operator", "");
		request.setAttribute("secondOpper", "");

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/calculator.jsp";

		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		String operator = request.getParameter("operator");
		double secondNum = Double.parseDouble(request.getParameter("secondNum"));
		String secondOpper = request.getParameter("secondOpper");

		ProcessedAndCutDecimal processedAndCutDecimal = ProcessedAndCutDecimalImpl.getInstance();
		Operator operatorImpl = OperatorImpl.getInstance();

		Number result = operatorImpl.operator(firstNum, secondNum, operator);
		Number firstNumForformula = processedAndCutDecimal.processed(firstNum);
		Number secondNumForformula = processedAndCutDecimal.processed(secondNum);

		String formula = firstNumForformula + " " + operator + " " + secondNumForformula + " = " + result + " "
				+ secondOpper;

		request.setAttribute("result", result);
		request.setAttribute("operator", secondOpper);
		request.setAttribute("secondOpper", secondOpper);
		request.setAttribute("formula", formula);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
