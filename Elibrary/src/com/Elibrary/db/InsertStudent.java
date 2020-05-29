package com.Elibrary.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Elibrary.pojo.Student;

public class InsertStudent {

public static boolean registerStudent(Student Std) {
	
	Connection con= ConnectDb.getConnection();
	PreparedStatement ptmt =null;
	boolean status =false;
	String query = " insert into student "
			+ " values(?,?,?,?,?,?,?,?) ";
	
	
	
	try {
		ptmt=con.prepareStatement(query);
		ptmt.setInt(1,Std.getSid());
		ptmt.setString(2, Std.getSname());
		ptmt.setString(3, Std.getScontact());
		ptmt.setInt(4,Std.getSage());
		ptmt.setString(5,Std.getSclass());
		ptmt.setString(6,Std.getAddress());
		ptmt.setString(7,Std.getPassword());
		ptmt.setString(8,Std.getEmail());
		
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

		
