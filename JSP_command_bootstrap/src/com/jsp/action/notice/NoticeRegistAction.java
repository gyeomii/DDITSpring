package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/regist_success";
		
		try {
			NoticeVO notice = HttpRequestParameterAdapter.execute(request, NoticeVO.class);
			
			notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
			
			noticeService.regist(notice);
			
		}catch(Exception e){
			e.printStackTrace();
			url = "/notice/regist_fail";
		}
		
		return url;
	}

}
