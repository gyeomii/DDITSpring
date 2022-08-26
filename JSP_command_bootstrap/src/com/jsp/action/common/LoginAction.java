package com.jsp.action.common;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.MemberService;

public class LoginAction implements Action {
	
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url ="redirect:/member/list.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String retUrl = request.getParameter("retUrl");
		
		if(retUrl != null) {
			url = "redirect:" + URLDecoder.decode(retUrl, "utf-8");
		}
		
		try {
			memberService.login(id, pwd);
			
			MemberVO member = memberService.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(10*60);//6분동안 사용자 요청이 없으면 server가 session 갱신
			
		}catch(NotFoundIdException | InvalidPasswordException e) {
			request.setAttribute("message", e.getMessage());
			url = "/common/login_fail";
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
