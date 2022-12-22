package com.bridgelabz.services;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.dto.BookDto;
import com.bridgelabz.models.BookStore;

public interface IBookService {
	  public ResponseEntity<Object> addBook(BookDto bookDto);
	  public ResponseEntity<Object> update(int id,BookDto bookDto);
	  public ResponseEntity<Object> delete(int id);
	  public ResponseEntity<Object> getBooks(int id);
	  public ResponseEntity<ArrayList<BookStore>> getAllBooks();
}
