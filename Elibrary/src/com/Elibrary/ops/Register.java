package com.Elibrary.ops;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.db.InsertStudent;
import com.Elibrary.pojo.Student;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String studid=request.getParameter("studid");
		String age=request.getParameter("age");
		String[] branchop=request.getParameterValues("option");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
	
		Student Std= new Student(Integer.parseInt(studid), name, contact, Integer.parseInt(age),branchop[0], address, password, email);
		boolean status =InsertStudent.registerStudent(Std);
		responce.setContentType("text/html");
		if(status) {
			
			request.getRequestDispatcher("profile").forward(request, responce);
		}
		else {
		
			request.getRequestDispatcher("index").forward(request, responce);
		}
	}
}
