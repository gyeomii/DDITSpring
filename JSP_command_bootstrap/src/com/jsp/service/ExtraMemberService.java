package com.jsp.service;

import com.jsp.dto.MemberVO;

public interface ExtraMemberService extends MemberService {
	
	// 회원 등록
	public void regist(MemberVO member) throws Exception;

	// 회원 수정
	public void Modify(MemberVO member) throws Exception;

	// 회원 탈퇴
	public void remove(String id) throws Exception;

}
