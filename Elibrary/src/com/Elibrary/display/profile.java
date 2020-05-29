package com.Elibrary.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.pojo.Student;

/**
 * Servlet implementation class profile
 */
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj=request.getServletContext().getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(obj!=null) {
			Student std =(Student)obj;
			request.getRequestDispatcher("header.html").include(request,response);
			request.getRequestDispatcher("nav.html").include(request, response);
			out.println(" <main><div class=\"display\">\r\n" + 
					"       <div class=\"accside\">\r\n" + 
					"           <h4>Students Information</h4>\r\n" + 
					"   <label for=\"name\">Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;:</label>"+std.getSname()+"<br>\r\n" + 
					"   <label for=\"Email\">Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>"+std.getEmail()+"<br>\r\n" + 
					"   <label for=\"Contact\">Contact &nbsp;&nbsp;&nbsp;&nbsp;:</label>"+std.getScontact()+"<br>\r\n" + 
					"   <label for=\"Age\">Age &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>"+std.getSage()+"<br>\r\n" + 
					"   <label for=\"studid\">Student Id  :</label>"+std.getSid()+"<br>\r\n" + 
					"   <label for=\"Address\">Address&nbsp;&nbsp;&nbsp;&nbsp;:</label>"+std.getAddress()+"<br>\r\n" + 
					"       </div>\r\n" + 
					"       <div class=\"searchbook\">\r\n" + 
					"           <h4>Find Books</h4>\r\n" +
					"<form action=\"search\">"+
					"            <input type=\"search\" name=\"searchb\" id=\"searchb\">\r\n" + 
					"            <br>\r\n" + 
					"            <input type=\"submit\" value=\"submit\" id=\"submit\">\r\n" + 
					"</from>"+
					"        </div>\r\n" + 
					"   </div>\r\n" + 
					"    </main>\r\n" + 
					"");
			
			request.getRequestDispatcher("footer.html").include(request, response);
			
		}
		else {
			response.sendRedirect("index");
		}
		
		}

	

}
