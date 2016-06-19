package com.henry.test;

import java.sql.SQLException;

import org.junit.Test;

import com.henry.dao.UserDao;

public class UserDaoTest {
	@Test
	public void add() throws SQLException {
		UserDao dao = new UserDao();
		dao.add("henry", "123");
	}
}
