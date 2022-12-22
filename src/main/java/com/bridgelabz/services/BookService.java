package com.bridgelabz.services;

import java.util.ArrayList;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.BookDto;

import com.bridgelabz.exception.ExistException;
import com.bridgelabz.exception.ResponseHandler;

import com.bridgelabz.models.BookStore;

import com.bridgelabz.repository.BookStoreRepository;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.utitity.TokenManager;


@Service
public class BookService implements IBookService{
   
	@Autowired
	BookStoreRepository bookRepository;
	@Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    ResponseHandler responseHandler;
    
    @Autowired
    TokenManager tokenManager;
	@Override
	public ResponseEntity<Object> addBook(BookDto bookDto) {
			 if(this.userRepository.findByRole("admin").isLogin()) {
					if(this.bookRepository.findByName(bookDto.getName())!=null) throw new ExistException("this book already exist");
					else {
						 BookStore book =mapper.map(bookDto, BookStore.class);
						 this.bookRepository.save(book);
						 return responseHandler.getResponse("add book successfully",bookDto); 
					}
			     }
				
				else {
					 throw new ExistException("your account logOut,Please login ");
				}
			
	}
	@Override
	public ResponseEntity<Object> update(int id, BookDto bookDto) {
		if(this.bookRepository.findById(id).isPresent())  
		  {
			 if(this.userRepository.findByRole("admin").isLogin()) {
				 BookStore book =mapper.map(bookDto, BookStore.class);
				 this.bookRepository.save(book);
				 return responseHandler.getResponse("Update Book successfully", book); 
			 }
			 throw new ExistException("your account logOut,Please login ");
		  }
		throw new ExistException("this doest not exist");
	}
	@Override
	public ResponseEntity<Object> delete(int id) {
		if(this.bookRepository.findById(id).isPresent())  
		  {
			 if(this.userRepository.findByRole("admin").isLogin()) {
				 this.bookRepository.deleteById(id);
				 return responseHandler.getResponse(" Book Deleted successfully"); 
			 }
			 throw new ExistException("your account logOut,Please login ");
		  }
		throw new ExistException("this doest not exist");
	}
	@Override
	public ResponseEntity<Object> getBooks(int id) {
	
		if(this.bookRepository.findById(id).isPresent())  
		  {
			 if(this.userRepository.findByRole("admin").isLogin()) {
			     BookStore book =this.bookRepository.findById(id).get();
			     BookDto bookDto =mapper.map(book, BookDto.class);
				 return responseHandler.getResponse(" your  Book Details", bookDto); 
			 }
			 throw new ExistException("your account logOut,Please login ");
		  }
		throw new ExistException("this doest not exist");
	}
	@Override
	public ResponseEntity<ArrayList<BookStore>> getAllBooks() {
	    if(this.bookRepository.findAll()==null) {
	    	throw new ExistException("Sorry, No Availbe any Book");
	    }
	            
	    ArrayList<BookStore> books =(ArrayList<BookStore>) this.bookRepository.findAll();
	 return new ResponseEntity<ArrayList<BookStore>>(books,HttpStatus.OK); 
	}
}
