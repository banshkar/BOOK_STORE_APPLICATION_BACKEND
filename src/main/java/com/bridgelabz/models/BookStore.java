package com.bridgelabz.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_store")
public class BookStore {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)	
  private int id;
  private String name;
  private String author;
  private int price;
 
  public BookStore() {
	super();

      }


public BookStore(int id, String name, String author, int price) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
	this.price = price;
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


}
