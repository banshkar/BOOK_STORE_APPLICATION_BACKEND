package com.bridgelabz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.BookDto;
import com.bridgelabz.dto.BookDtoCart;
import com.bridgelabz.dto.Login;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.models.BookStore;
import com.bridgelabz.models.Cart;
import com.bridgelabz.services.IBookService;
import com.bridgelabz.services.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
      
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IBookService iBookService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> addUser(@RequestBody RegisterDto registerDto){
		return this.iUserService.addUser(registerDto);
	}

	@GetMapping("/getDetails/{token}")
	public ResponseEntity<Object> getDetails(@PathVariable String token){
		return this.iUserService.getDetails(token);
	}
	
	@PutMapping("/update/{token}")
	public ResponseEntity<Object> update(@PathVariable String token,@RequestBody RegisterDto registerDto){
		return this.iUserService.update(token, registerDto);
	}
	
	@DeleteMapping("/deleted")
	public ResponseEntity<Object> deleted(@RequestParam String token){
		return this.iUserService.delete(token);
	}

	@PostMapping("/addBookToCart/{token}")
	public ResponseEntity<Object> addBookToCart(@PathVariable String token ,@RequestBody List<BookDtoCart> bookStores){
		 System.out.println("not working"+token);
		 System.out.println("book"+bookStores);
		return this.iUserService.addBookToCart(token, bookStores);
	}
	@GetMapping("/getCartItem/{token}")
	public ResponseEntity<List<Cart>> getCartItem(@PathVariable String token){
		   return this.iUserService.getCart(token);
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Login login){
		return this.iUserService.login(login);
	}
	@GetMapping("/logOut/{token}")
	public ResponseEntity<Object> logOut(@PathVariable String token){
		return this.iUserService.Logout(token);
	}
	
	@PostMapping("/admin/addbook")
   public ResponseEntity<Object> addBook(@RequestBody BookDto bookDto){
	   
	   return this.iBookService.addBook(bookDto);
   }
   @PutMapping("/admin/addbook/{id}")
   public ResponseEntity<Object> updateBook(@PathVariable int id,@RequestBody BookDto bookDto){
		   
		   return this.iBookService.update(id, bookDto);
	   }  
   @DeleteMapping("/admin/deleted/{id}")
   public ResponseEntity<Object> deleted(@PathVariable int id){
	    
	   return this.iBookService.delete(id);
   }
    @GetMapping("/admin/getAllBookStore")
	public ResponseEntity<ArrayList<BookStore>> getAllBookStore(){
		return this.iBookService.getAllBooks();
   }
   @GetMapping("/admin/getBook/{id}")
   public ResponseEntity<Object> getBook(@PathVariable int id){
	   return this.iBookService.getBooks(id);
   }
   @GetMapping("/getPrice/{token}")
   public ResponseEntity<Object> getBook(@PathVariable String token){
	   return this.iUserService.getTotal(token);
   }
   
   @GetMapping("/deletedItem/{token}")
   public ResponseEntity<Object> deletedItem(@PathVariable int token){
	   return this.iUserService.removeItem(token);
   }
   @GetMapping("/orderPlace/{token}")
   public ResponseEntity<Object> order(@PathVariable String token){
	   return this.iUserService.orderPlace(token);
   }

}
