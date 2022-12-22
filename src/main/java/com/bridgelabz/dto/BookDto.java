package com.bridgelabz.dto;




public class BookDto {
	  private String name;
	  private String author;
	  private int price;
	  public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	  public BookDto(String name, String author, int price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;

	}
	public String getName() {
		return name;
	  }
	  public void setName(String name) {
	 	this.name = name;
	 }
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookDto [name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	
	

}
