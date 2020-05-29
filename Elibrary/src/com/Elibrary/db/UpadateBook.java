package com.Elibrary.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
 

public class UpadateBook {

	public static boolean issueBook(int bid) {
		
		Connection con=	ConnectDb.getConnection();
		PreparedStatement ptmt=null;	
		int res;
		boolean status =false;
		
		String Query=" update ebook "
				+" set status ='true' "
				+" where bid = ? ";
			
			try {
				ptmt=con.prepareStatement(Query);
				ptmt.setInt(1, bid);
			 res=ptmt.executeUpdate();
				
			if(res > 0) {
			
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
}

	
	public static boolean returnBook(int bid) {
	Connection con=	ConnectDb.getConnection();
	PreparedStatement ptmt=null;	
	int res;
	boolean status =false;
	
	String Query=" update ebook "
			+" set status ='false' "
			+" where bid = ? ";
		
		try {
			ptmt=con.prepareStatement(Query);
			ptmt.setInt(1, bid);
		 res=ptmt.executeUpdate();
			
		if(res > 0) {
		
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
		
	}
	} 

