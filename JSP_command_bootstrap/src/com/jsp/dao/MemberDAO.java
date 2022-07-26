package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberDAO {
	
	//회원 리스트 조회
	List<MemberVO> selectMemberList() throws SQLException;
	// 회원검색
	MemberVO selectMemberById(String id) throws SQLException;
}
