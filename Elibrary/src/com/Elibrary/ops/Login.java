package com.Elibrary.ops;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.db.RetriveStudent;
import com.Elibrary.pojo.Student;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =request.getParameter("user");
		String pass =request.getParameter("pass");
		
	boolean status =RetriveStudent.loginUser(email, pass);
	if(status) {
	//	response.getWriter().println("login successfull");
		Student std = RetriveStudent.getStudent(email);
		request.getServletContext().setAttribute("user", std);
		request.getRequestDispatcher("profile").forward(request, response);
	}else {
		//		response.getWriter().println("Invalid login creadential");
		response.sendRedirect("index");
	}
	}

}
