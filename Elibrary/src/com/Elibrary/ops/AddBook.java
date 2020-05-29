package com.Elibrary.ops;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Elibrary.bookDb.InsertBook;
import com.Elibrary.pojo.Book;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String bauther=request.getParameter("bauther");
		String bprice=request.getParameter("bprice");
		String bgen=request.getParameter("bgen");
		String bstatus=request.getParameter("bstatus");
	
		Book bk =new Book(Integer.parseInt(bid), bname, bauther,  bgen, Double.parseDouble(bprice),bstatus);
	
		boolean status =InsertBook.addBook(bk);
		responce.setContentType("text/html");
		if(status) {
			
			responce.getWriter().println("book Added Successfully");
		}
		else {
		
			responce.getWriter().println("failed to add book");		}
	}
}
