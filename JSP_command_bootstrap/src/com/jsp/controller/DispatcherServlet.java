package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class DispatcherServlet extends HttpServlet {
	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("url.properties");
		
		try {
			if(path != null) {
				handlerMapper = new HandlerMapper(path);
			}else {
				handlerMapper = new HandlerMapper();
			}
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다.");
		}catch (Exception e) {
			System.out.println("[DispatcherServlet] handlerMapper 가 실패했습니다");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 URI검증
		String command = request.getRequestURI(); // contextPath포함
		if(command.indexOf(request.getContextPath()) == 0) { // contextPath  삭제/member/list
			command = command.substring(request.getContextPath().length());
		}
		//commandHandler 실행(HandlerMapper 의뢰 action 할당)
		Action action = null;
		String view = null;
		
		if(handlerMapper != null) {
			action = handlerMapper.getAction(command);
			if(action != null) { // 올바른 요청
				try {
					view = action.process(request, response);
					if(view == null) {
						return;
					}
					request.setAttribute("viewName", view);
					JSPViewResolver.view(request, response);
					
				}catch (Exception e) {
					e.printStackTrace();
					// 톰캣 에러페이지
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					// 에러페이지를 내가 만든 화면으로 컨트롤 하고 싶으면
					//request.setAttribute("viewName", "/error/servlet_error");
					//response.setStatus(500);
					//JSPViewResolver.view(request, response);
				}
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
