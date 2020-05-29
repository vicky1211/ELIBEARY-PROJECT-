package com.Elibrary.pojo;



public class Student {
	private int sid;
	private String sname;
	private String scontact;
	private int sage;
	private String sclass;
	private String address;
	private String password;
	private String email;
	
	public Student() {
		
	}

	public Student(int sid, String sname, String scontact, int sage, String sclass, String address, String password,
			String email) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scontact = scontact;
		this.sage = sage;
		this.sclass = sclass;
		this.address = address;
		this.password = password;
		this.email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScontact() {
		return scontact;
	}

	public void setScontact(String scontact) {
		this.scontact = scontact;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scontact=" + scontact + ", sage=" + sage + ", sclass="
				+ sclass + ", address=" + address + ", password=" + password + ", email=" + email + "]";
	}
	
}