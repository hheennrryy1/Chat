package com.henry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.henry.util.JdbcUtil;

public class UserDao {
	
	public void add(String username, String password) throws SQLException {
		String sql = "insert into user (username, password) values (?, ?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, username);
	    pstmt.setString(2, password);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public boolean get(String username, String password) throws SQLException {
		String sql = "select u.username from user u where u.username = ? and u.password = ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		boolean flag = false;
		
		if(rs.next()) {
			flag = true;
		}
		pstmt.close();
		conn.close();
		rs.close();
		return flag;
	}
}
