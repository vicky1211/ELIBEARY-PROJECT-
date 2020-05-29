package com.Elibrary.bookDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Elibrary.db.ConnectDb;
import com.Elibrary.pojo.Book;


public class RetriveBook {
	public static ArrayList<Book> getBook(){
		ArrayList<Book> book = new ArrayList<Book>();
	
		Connection con=	ConnectDb.getConnection();
		PreparedStatement ptmt=null;	
		ResultSet res=null;
		Book bk=null;
		
		String Query=" select * from ebook ";
			
			try {
				ptmt=con.prepareStatement(Query);
				
			 res=ptmt.executeQuery();
				
			while(res.next()) {
			
				bk=new Book(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getString(6));
				book.add(bk);
			}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {if(con!=null)
					con.close();
				if(ptmt!=null)
					ptmt.close();
				if(res!=null)
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			
		return book;
}
public static ArrayList<Book> getBook(String bookName) {
	ArrayList<Book> book = new ArrayList<Book>();
	Connection con=	ConnectDb.getConnection();
	PreparedStatement ptmt=null;	
	ResultSet res=null;
	 Book bk =null;
	String pattern ="%"+bookName+"%";
	String Query=" select * from ebook "
				+ "where bname like ? ";
		try {
			ptmt=con.prepareStatement(Query);
			ptmt.setString(1,pattern);
		 res=ptmt.executeQuery();
		 
			
		while(res.next()) {
		
			bk=new Book(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getString(6));
			book.add(bk);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {if(con!=null)
				con.close();
			if(ptmt!=null)
				ptmt.close();
			if(res!=null)
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	return book;
}
public static Book getBook(int bid){
	

	Connection con=	ConnectDb.getConnection();
	PreparedStatement ptmt=null;	
	ResultSet res=null;
	Book bk=null;
	
	String Query=" select * from ebook "
			+" where bid = ?";
		
		try {
			ptmt=con.prepareStatement(Query);
			ptmt.setInt(1, bid);
		 res=ptmt.executeQuery();
			
		while(res.next()) {
		
			bk=new Book(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getString(6));
					}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {if(con!=null)
				con.close();
			if(ptmt!=null)
				ptmt.close();
			if(res!=null)
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	return bk;
}
}

