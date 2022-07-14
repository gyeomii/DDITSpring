package com.java.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.datasource.JDBCDataSource;
import com.java.dto.MemberVO;

public class TestJDBCSource {
	
	private Connection conn;
	
	@Before
	public void init() throws Exception {
		JDBCDataSource dataSource = JDBCDataSource.getInstance();	
		conn = dataSource.getConnection();
	}
	
	@Test
	public void selectMember() throws Exception{
		String testId = "mimi";
		
		String sql = "select id" + " from member" + " where id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, testId);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVO member = new MemberVO();
		
		if(rs.next()) {
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(testId, member.getId());
	}
	
	@After
	public void complete() throws SQLException {
		if(conn!=null)conn.close();
	}
}
