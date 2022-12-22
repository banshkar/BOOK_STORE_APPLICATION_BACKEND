package com.bridgelabz.dto;

public class BookDtoCart {
   
	  private String name;                          
	  private int quantity;
	  private String author;
	  private int price;
	
	public BookDtoCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDtoCart(String name, int quantity, String author, int price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.author = author;
		this.price = price;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "BookDtoCart [name=" + name + ", quantity=" + quantity + ", author=" + author + ", price=" + price + "]";
	}
	
	

}
