package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helper.ConnectionProvider;


@WebServlet("/Loadename")
public class Loadename extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con1 = ConnectionProvider.createConnection();
			
			String q = "SELECT ename FROM empdetails WHERE eid = ?";
			PreparedStatement pstmt1 = con1.prepareStatement(q);
			pstmt1.setInt(1, emp_id);
			ResultSet set1 = pstmt1.executeQuery();
			HttpSession session = request.getSession();
			
			while (set1.next()) {
				session.setAttribute("employee_name", set1.getString("ename"));
				session.setAttribute("employee_id", emp_id);
				session.setAttribute("getAlert", "NA");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			con1.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("inside Loadename servlet");
		}
	}

}
