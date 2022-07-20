package com.jsp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/home.jsp";
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date now = new Date();
//		String today = format.format(now);
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		request.setAttribute("today", today);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}