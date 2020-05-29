package com.Elibrary.display;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexPage 
 */
public class indexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
			request.getRequestDispatcher("header.html").include(request, responce);
			request.getRequestDispatcher("home.html").include(request, responce);
			request.getRequestDispatcher("footer.html").include(request, responce);
		}
}
