package com.henry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.henry.util.JdbcUtil;

public class UserDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void add(String username, String password) {
		String sql = "insert into user (username, password) values (?, ?)";
		try {
			conn = JdbcUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstmt, null);
		}
	}
	
	public boolean get(String username, String password) {
		String sql = "select u.username from user u where u.username = ? and u.password = ?";
		boolean flag = false;
		try {
			conn = JdbcUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstmt, rs);
		}
		return flag;
	}
}
