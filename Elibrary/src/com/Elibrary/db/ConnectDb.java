package com.Elibrary.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectDb {
	public static Connection getConnection() {
		Connection con=null;
		

		try {
		Driver dref	=new Driver();
		DriverManager.registerDriver(dref);
		
		
		String dburl ="jdbc:mysql://localhost:3306/Elibrary?user=root&password=root"; 
		 con =DriverManager.getConnection(dburl);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}}
