package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Employee;
import com.helper.ConnectionProvider;

public class SaveEmployee extends HttpServlet {
	public static boolean saveInDatabase(Employee employee) {
		boolean check = false;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = ConnectionProvider.createConnection();
			String query = "UPDATE empdetails SET yoe = ? ,designation = ? WHERE eid = ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, employee.getYoe());
			pstmt.setString(2, employee.getDesignation());
			pstmt.setInt(3, employee.getEid());
			count = pstmt.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("inside SaveEmployee dao");
			e.printStackTrace();
		}
		
		if(count != 0) {
			check = true;
			System.out.println("saved "+check);
		}
		
		return check;
		
	}
	
}
