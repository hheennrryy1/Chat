package com.henry.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
	private static Properties prop = new Properties();
	private static String url, username, password, driver;
	private static InputStream in;
	
	static {
		try {
			//去当前项目的classes下找
			in = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
			prop.load(in);
			url = prop.getProperty("url"); 
			username = prop.getProperty("username"); 
			password = prop.getProperty("password"); 
			driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
