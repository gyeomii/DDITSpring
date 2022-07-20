package com.cal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/calculator.jsp";
		request.setAttribute("result", 0);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/calculator.jsp";

		int firstNum = Integer.parseInt(request.getParameter("firstNum"));
		int secondNum = Integer.parseInt(request.getParameter("secondNum"));

		String operator = request.getParameter("operator");

		Operator operatorImol = OperatorImpl.getInstance();
		int result = operatorImol.operator(firstNum, secondNum, operator);

		request.setAttribute("result", result);

		request.getRequestDispatcher(url).forward(request, response);

	}

}
