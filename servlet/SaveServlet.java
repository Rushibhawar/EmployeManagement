package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SaveEmployee;
import com.entities.Employee;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int eid = Integer.parseInt(request.getParameter("empid"));
		String ename = request.getParameter("empname");
		int yearofexperience = Integer.parseInt(request.getParameter("yearofexperience"));
		String designation = request.getParameter("designation");
		
		Employee employee = new Employee(eid, ename, yearofexperience, designation);
		
		boolean check = SaveEmployee.saveInDatabase(employee);
		HttpSession session = request.getSession();
		if(check == true) {
			session.setAttribute("getAlert", "Yes");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else {
			session.setAttribute("getAlert", "No");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

}
