 package com.Elibrary.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Elibrary.pojo.Student;

public class RetriveStudent {

	public static Student getStudent(String email){
		
	Connection con=	ConnectDb.getConnection();
	PreparedStatement ptmt=null;	
	ResultSet res=null;
	Student std=null;
	
	String Query=" select * from student "
				+" where email = ? ";
		
		try {
			ptmt=con.prepareStatement(Query);
			ptmt.setString(1,email);
			
		 res=ptmt.executeQuery();
			
		if(res.next()) {
		
			std= new Student(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),res.getString(5),res.getString(6), res.getString(7), res.getNString(8));
			
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
	return std;
}
	public static boolean loginUser(String email,String pass ){
		boolean status =false;
		Student std=getStudent(email);
		if(std!=null) {
			if(pass.equals(std.getPassword())) {
				status =true;
			}
		}
		return status;
}	
}
