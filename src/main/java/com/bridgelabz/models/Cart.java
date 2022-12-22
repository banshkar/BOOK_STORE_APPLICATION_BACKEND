package com.bridgelabz.models;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	  private String name;                          
	  private int quantity;
	  private String author;
	  private int price;
	  @ManyToOne(cascade = CascadeType.ALL)
	  private User user;
	  
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, String name, int quantity, String author, int price,User user) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.author = author;
		this.price = price;
		this.user =user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", quantity=" + quantity + ", author=" + author + ", price="
				+ price + ", user=" + user + "]";
	}
	
	

}
