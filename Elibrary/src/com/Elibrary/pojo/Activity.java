package com.Elibrary.pojo;

import java.sql.Date;

public class Activity {
private int aid;
private int bid;
private int sid;
private java.sql.Date date;
private String status;

public Activity() {
	
}

public Activity(int aid, int bid, int sid, Date date, String status) {
	super();
	this.aid = aid;
	this.bid = bid;
	this.sid = sid;
	this.date = date;
	this.status = status;
}

public int getAid() {
	return aid;
}

public void setAid(int aid) {
	this.aid = aid;
}

public int getBid() {
	return bid;
}

public void setBid(int bid) {
	this.bid = bid;
}

public int getSid() {
	return sid;
}

public void setSid(int sid) {
	this.sid = sid;
}

public java.sql.Date getDate() {
	return date;
}

public void setDate(java.sql.Date date) {
	this.date = date;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "Activity [aid=" + aid + ", bid=" + bid + ", sid=" + sid + ", date=" + date + ", status=" + status + "]";
}

}
