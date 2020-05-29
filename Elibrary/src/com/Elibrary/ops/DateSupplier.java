package com.Elibrary.ops;

public class DateSupplier {
	public static java.sql.Date getCurrentDate(){
		java.sql.Date currentDate =null;
		java.util.Date date= java.util.Calendar.getInstance().getTime();
		currentDate =new java.sql.Date(date.getTime());
		return currentDate;
	}

}
