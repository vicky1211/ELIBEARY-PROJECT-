package com.Elibrary.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.bookDb.RetriveBook;
import com.Elibrary.db.ActivityLog;
import com.Elibrary.db.UpadateBook;
import com.Elibrary.pojo.Activity;
import com.Elibrary.pojo.Book;
import com.Elibrary.pojo.Student;

/**
 * Servlet implementation class IssuedPage
 */
public class IssuedPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuedPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String bid =request.getParameter("bid");
		Object obj=request.getServletContext().getAttribute("user");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		if(obj != null) {
			//action

			
			Student std =(Student)obj;
			String bid = request.getParameter("bid");
			if(bid!=null) {
				///isuuse book
				///create activity

				UpadateBook.issueBook(Integer.parseInt(bid));
				ActivityLog.insertActivity(std.getSid(),Integer.parseInt(bid));
				
				
				
			}
			ArrayList<Activity> activities =ActivityLog.getLogs(std.getSid());
			request.getRequestDispatcher("header.html").include(request,response);
			request.getRequestDispatcher("nav.html").include(request, response);
			out.println("   <main>\r\n" + 
					"      <div class=\"issued\">\r\n" + 
					"          <div id=\"title\">\r\n" + 
					"            <h4>Issue Book</h4>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"table\">\r\n" + 
					"            <table style=\"border: 2px solid black;border-collapse: collapse;width: 400px;height: 200px;\">\r\n" + 
					"   \r\n" + 
					"                <tr>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Sr No</th>\r\n" + 
					
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Book name</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color:blue;border-collapse: collapse;text-align: center; \">Book Auther</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Price</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Status</th>\r\n" + 
					"                    \r\n" + 
					"                   \r\n" + 
					"            \r\n" + 
					"                </tr>");
			
	
			if(!activities.isEmpty()) {
		
				for (int i = 0; i < activities.size(); i++) {
					Book books = RetriveBook.getBook(activities.get(i).getBid());
					out.println(" <tr>\r\n" + 
							"<td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+i+"</td>\r\n" + 
												
							"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+books.getBookName()+"</td>\r\n" + 
							"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+books.getBookAuther()+"</td>\r\n" + 
							"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+books.getBookPrice()+"</td>\r\n" + 
							"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+books.getReturnStatus()+"</td>\r\n" + 
							"                  \r\n" + 
							"                </tr>\r\n" + 
							"              ");
				}
				}
			else {
					out.println("<tr ><td colspan=\"7\">not any book is issue <td></tr>");
				}
			out.println(" </table>\r\n" + 
					"            \r\n" + 
					"    \r\n" + 
					"    \r\n" + 
					"          </div>\r\n" + 
					"      </div>  \r\n" + 
					"    </main>");
			
			
			
			request.getRequestDispatcher("footer.html").include(request, response);
		}
		else{
			response.sendRedirect("index");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
