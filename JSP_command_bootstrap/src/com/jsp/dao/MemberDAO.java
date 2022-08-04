package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionException;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {
	// 회원목록 조회
	List<MemberVO> selectMemberList(Criteria cri)throws SQLException;
	// 일반 리스트 전체 개수
	int selectMemberListCount(Criteria cri) throws SQLException;
	// 회원 검색
	MemberVO selectMemberById(String id)throws SQLException;
	//회원 추가
	public void insertMember(MemberVO member) throws SqlSessionException;
	//회원 수정
	public void updateMember(MemberVO member) throws SqlSessionException;	
	//회원 삭제
	public void deleteMember(String id) throws SqlSessionException;
	
}
