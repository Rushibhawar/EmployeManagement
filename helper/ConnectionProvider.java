package com.helper;

import java.sql.DriverManager;

import java.sql.Connection;

public class ConnectionProvider {
	private static Connection con;
	
	public static  Connection createConnection() {
		
		try {
			
			String url = "jdbc:mysql://localhost/quadwave";
			String username = "root";
			String password = "1213";
			
			con = (Connection) DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("inside connectionProvider");
			e.printStackTrace();
		}
		
		return con;
		
	}
}
