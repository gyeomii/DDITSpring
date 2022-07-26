package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	//회원 리스트 조회
	List<MemberVO> getMemberList() throws SQLException;
	// 회원검색
	MemberVO getMember(String id) throws SQLException;
}
