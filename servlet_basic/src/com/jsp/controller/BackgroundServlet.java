package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/background/color")
public class BackgroundServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String html = "";
		html += "<!DOCTYPE>\n";
		html += "<html>\n";
			html += "<head>\n";
				html += "<title>\n";
					html += "배경색 바꾸기\n";
				html += "</title>\n";
				html += "<style>\n";
					html += "body{background:"+color+";}\n";
				html += "</style>\n";
			html += "</head>\n";
			html += "<body>\n";
			html += "</body>\n";
		html += "</html>\n";
		
		out.println(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
