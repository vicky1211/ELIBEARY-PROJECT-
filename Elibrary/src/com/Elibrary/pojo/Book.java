package com.Elibrary.pojo;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuther;

	private String bookGen;
	private double bookPrice;
	private String bookStatus;
	
	public Book(){
		
	}

	public Book(int bookId, String bookName, String bookAuther,  String bookGen,double bookPrice,String bookStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		
		this.bookGen = bookGen;
		this.bookPrice = bookPrice;
		this.bookStatus = bookStatus;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookGen() {
		return bookGen;
	}

	public void setBookGen(String bookGen) {
		this.bookGen = bookGen;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getIsseStatus() {
		if(this.bookStatus.equals("true"))
		{
			return "<a >issue</a>";
		}else {
			return "<a href=\"issue?bid="+this.bookId+"\">issued</a>";
			
		}
	}
	public String getReturnStatus() {
		return "<a href=\"return?bid="+this.bookId+"\">return</a>";
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuther=" + bookAuther + ", bookPrice="
				+ bookPrice + ", bookGen=" + bookGen + ", bookStatus=" + bookStatus + "]";
	}

}
