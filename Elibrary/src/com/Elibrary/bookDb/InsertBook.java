package com.Elibrary.bookDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Elibrary.db.ConnectDb;
import com.Elibrary.pojo.Book;

public class InsertBook {
	public static boolean addBook(Book bk) {
		
		Connection con= ConnectDb.getConnection();
		PreparedStatement ptmt =null;
		boolean status =false;
		String query = " insert into ebook "
				+ " values(?,?,?,?,?,?) ";
		
		
		
		try {
			ptmt=con.prepareStatement(query);
			ptmt.setInt(1,bk.getBookId());
			ptmt.setString(2,bk.getBookName());
			ptmt.setString(3, bk.getBookAuther());
			ptmt.setString(4,bk.getBookGen());
			ptmt.setDouble(5,bk.getBookPrice());
			ptmt.setString(6, bk.getBookStatus());
			
			
			int res =ptmt.executeUpdate();
			
			if(res>0) {
				status = true;
				
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}

		return status;
		}}

			

