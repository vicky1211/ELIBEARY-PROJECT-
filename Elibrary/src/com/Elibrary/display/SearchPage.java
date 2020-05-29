package com.Elibrary.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.bookDb.RetriveBook;
import com.Elibrary.pojo.Book;


public class SearchPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
			String bname=request.getParameter("searchb");	
		Object obj =request.getServletContext().getAttribute("user");
		if(obj!=null) {
			ArrayList<Book> book =RetriveBook.getBook(bname);
			request.getRequestDispatcher("header.html").include(request,response);
			request.getRequestDispatcher("nav.html").include(request, response);
		out.println(" <main>\r\n" + 
				"        <div class=\"main\">\r\n" + 
				"         \r\n" + 
				"            <div class=\"searchbox\"><form action=\"search\">" + 
				"                <input type=\"search\" name =\"searchb\" id=\"searchb\" placeholder=\"Find Books...\">\r\n" + 
				"                <input type=\"submit\" value=\"submit\" id=\"submit\">\r\n" + 
				"            </form>\r\n" + 
				"            </div>   ");
			
			out.println("<table style=\"border: 2px solid black;border-collapse: collapse;width: 400px;height: 200px;margin-top:50px;\r\n" + 
					"margin-left :100px;\">\r\n" + 
					"   \r\n" + 
					"                <tr>\r\n" + 
					"<th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">sr no</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Book name</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color:blue;border-collapse: collapse;text-align: center; \">Book Auther</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Price</th>\r\n" + 
					"                    <th style=\"border: 2px solid black;background-color :blue;border-collapse: collapse;text-align: center; \">Status</th>\r\n" + 
					"                    \r\n" + 
					"                   \r\n" + 
					"            \r\n" + 
					"                </tr>");
			if(!book.isEmpty()) {
			for (int i = 0; i < book.size(); i++) {
				out.println("<tr>\r\n" + 
			            "   <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+i+"</td style=\"border: 2px solid black;background-color :crimson;border-collapse: collapse;text-align: center; \">\r\n" + 
							                 
						"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+book.get(i).getBookName()+"</td style=\"border: 2px solid black;background-color :crimson;border-collapse: collapse;text-align: center; \">\r\n" + 
						"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+book.get(i).getBookAuther()+"</td style=\"border: 2px solid black;background-color :crimson;border-collapse: collapse;text-align: center; \">\r\n" + 
						"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+book.get(i).getBookPrice()+"</td>\r\n" + 
						"                    <td style=\"border: 2px solid ghostwhite;background-color :crimson;border-collapse: collapse;text-align: center; \">"+book.get(i).getBookStatus()+"</td>\r\n" + 
						"                  \r\n" + 
						"                </tr>");
			}
			}else {
				out.println("<tr ><td colspan=\"7\">match not found <td></tr>");
			}
			out.println("</table>\r\n" + 
					"        \r\n" + 
					"            </div>\r\n" + 
					"       \r\n" + 
					"        </div>\r\n" + 
					"        \r\n" + 
					"    </main>");
			
			
			request.getRequestDispatcher("footer.html").include(request, response);
		}
		else {
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
