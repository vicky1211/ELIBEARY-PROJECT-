package com.Elibrary.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

 

import com.Elibrary.ops.DateSupplier;
import com.Elibrary.pojo.Activity;
 

public class ActivityLog {

	public static boolean insertActivity(int sid,int bid) {
		boolean status =false;
		if(UpadateBook.issueBook(bid)) 
		{
			Connection con= ConnectDb.getConnection();
			PreparedStatement ptmt =null;
			
			String query = " insert into activity "
					+ " values(?,?,?,?,?) ";
						
			try {
				ptmt=con.prepareStatement(query);
				ptmt.setInt(1,getAid()+1);
				ptmt.setInt(2,sid);
				ptmt.setInt(3,bid);
				ptmt.setDate(4, DateSupplier.getCurrentDate()); 
				ptmt.setString(5,"issued");
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
	
		}
		else {
			status =false;
		}
		
		return status;
	}
	public static  ArrayList<Activity> getLogs(int sid){
		ArrayList<Activity> activities = new ArrayList<Activity>();
		
		Connection con=	ConnectDb.getConnection();
		PreparedStatement ptmt=null;	
		ResultSet res=null;
	
		
		String Query=" select * from activity "
				+" where sid = ? and status ='issued' ";
			
			try {
				ptmt=con.prepareStatement(Query);
				ptmt.setInt(1, sid);
			 res=ptmt.executeQuery();
				
			while(res.next()) {
				Activity activity=new Activity(res.getInt("aid"), res.getInt("bid"),res.getInt("sid"), res.getDate("date"),res.getString("status"));
				activities.add(activity);
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
			
		return activities;
	}
	
public static int getAid() {
	Connection con =ConnectDb.getConnection();
	PreparedStatement ptmt =null;
	ResultSet res =null;
	int aid= 100001;
	String query= " select max(aid) from activity ";
	
	try {
		ptmt=con.prepareStatement(query);
		
		res=ptmt.executeQuery();
		
		while(res.next()) {
			aid=res.getInt(1);
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
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
return aid;
}

public static ArrayList<Activity> getReturnLog(int sid) {
	ArrayList<Activity> activities = new ArrayList<Activity>();
	
	Connection con=	ConnectDb.getConnection();
	PreparedStatement ptmt=null;	
	ResultSet res=null;

	
	String Query=" select * from activity "
			+" where sid = ? and status ='returned' ";
		
		try {
			ptmt=con.prepareStatement(Query);
			ptmt.setInt(1, sid);
		 res=ptmt.executeQuery();
			
		while(res.next()) {
			Activity activity=new Activity(res.getInt("aid"), res.getInt("bid"),res.getInt("sid"), res.getDate("date"),res.getString("status"));
			activities.add(activity);
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
		
	return activities;
}
public static boolean returnActivity(int sid ,int bid){
	Connection con = ConnectDb.getConnection();
	PreparedStatement ptmt = null;
	boolean status = false;
	
	String query = " update activity "
			+ " set status = 'returned', date = ? "
			+ " where sid = ? and bid = ? ";
	
	try 
	{
		ptmt = con.prepareStatement(query);
		
		ptmt.setDate(1, DateSupplier.getCurrentDate());
		ptmt.setInt(2, sid);
		ptmt.setInt(3, bid);
		
		
		int res = ptmt.executeUpdate();
		
		if(res>0)
		{
			status = true;
		}
		
		
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try 
		{
			if(con!=null)
			{
				con.close();
			}
			
			if(ptmt!=null)
			{
				ptmt.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	return status;
}
}

	
	