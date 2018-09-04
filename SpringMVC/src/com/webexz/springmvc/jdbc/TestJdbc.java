package com.webexz.springmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "HR";
		String password = "HR";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}