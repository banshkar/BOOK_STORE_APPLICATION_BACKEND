package com.bridgelabz.services;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.BookDtoCart;
import com.bridgelabz.dto.Login;
import com.bridgelabz.dto.RegisterDto;
import com.bridgelabz.exception.ExistException;
import com.bridgelabz.exception.ResponseHandler;
import com.bridgelabz.models.Cart;
import com.bridgelabz.models.BookStore;
import com.bridgelabz.models.User;
import com.bridgelabz.repository.BookCartRepo;
import com.bridgelabz.repository.BookStoreRepository;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.utitity.TokenManager;



@Service
public class UserService implements IUserService{
    
	 @Autowired
	 UserRepository userRepository;
	@Autowired
	TokenManager tokenManager;
     @Autowired	
	 ModelMapper mapper;
     @Autowired
     ResponseHandler responseHandler;
 	@Autowired
 	BookStoreRepository bookRepository;
 	@Autowired
 	BookCartRepo bookCartRepo;
	@Override
	public ResponseEntity<Object> addUser(RegisterDto registerDto) {
	   if(this.userRepository.findByEmail(registerDto.getEmail())==null) {
           User user =mapper.map(registerDto, User.class);
            List<Cart>cat =new ArrayList<>();
            user.setCart(cat);
		   this.userRepository.save(user);
	
		   return responseHandler.getResponse("created User Successfully", registerDto);
	   }
	   throw new ExistException("already register");
	}

	@Override
	public ResponseEntity<Object> update(String token, RegisterDto registerDto) {
		String email =this.tokenManager.getEmailDecode(token);
		if(this.userRepository.findByEmail(email).isLogin()) {
			int id =this.userRepository.findByEmail(email).getId();
			
			List<Cart>list =this.userRepository.findByEmail(email).getCart();
			 System.out.println(list);
			User updateUser =mapper.map(registerDto, User.class);
			updateUser.setId(id);		
			updateUser.setLogin(true);
			updateUser.setCart(list);
			this.userRepository.save(updateUser);
			return responseHandler.getResponse("Update Successfully", registerDto);
		}
		throw new ExistException("Your account LogOut ,Please Login After you can update data");
	}
	@Override
	public ResponseEntity<Object> delete(String token) {
		String email =this.tokenManager.getEmailDecode(token);
		if(this.userRepository.findByEmail(email).isLogin()) {
			int id =this.userRepository.findByEmail(email).getId();
	        this.userRepository.deleteById(id);
			return responseHandler.getResponse("User Deleted Successfully");
		}
		throw new ExistException("Your account LogOut ,Please Login After you can update data");
	}

	@Override
	public ResponseEntity<Object> getDetails(String token) {
		String email =this.tokenManager.getEmailDecode(token);
		if(this.userRepository.findByEmail(email).isLogin()) {
			User user =this.userRepository.findByEmail(email);
			RegisterDto details =mapper.map(user, RegisterDto.class);
			return responseHandler.getResponse("Your Details ",details);
		}
		throw new ExistException("Your account LogOut ,Please Login After you can update data");
	}
	@Override
	public ResponseEntity<Object> login(Login login) {
		 if(this.userRepository.findByEmail(login.getEmail())==null) {
			 throw new ExistException("please Create Account");
		 }
		 else {
			 if(this.userRepository.findByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
				 User user =this.userRepository.findByEmail(login.getEmail());
				 user.setLogin(true);
				 this.userRepository.save(user);
				 String token =this.tokenManager.generateToken(login);
				 return responseHandler.getResponse("Login", token);
			 }
			 throw new ExistException("Please Enter right password");
		 }
	}

	@Override
	public ResponseEntity<Object> Logout(String token) {
		String email =this.tokenManager.getEmailDecode(token);
			User user =this.userRepository.findByEmail(email);
			user.setLogin(false);
			this.userRepository.save(user);
		   return new ResponseEntity<Object>("LogOut",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> addBookToCart(String token,List<BookDtoCart> bookDtoCart) {
	
		String email =this.tokenManager.getEmailDecode(token); 
		if(this.userRepository.findByEmail(email).isLogin()==true) {
		     boolean found =false;	
			 Iterator<BookDtoCart> listitr =bookDtoCart.iterator();
			 while(listitr.hasNext()) {
				BookDtoCart bookDtoCart2 =listitr.next();		
				if(this.bookCartRepo.findByName(bookDtoCart2.getName())==null) {
					Cart cart =mapper.map(bookDtoCart2, Cart.class);
					User user =this.userRepository.findByEmail(email);;
					user.getCart().add(cart);
					this.userRepository.save(user);
					found =true;
				}
				else {
					 User user =this.userRepository.findByEmail(email);
					Cart cart =this.bookCartRepo.findByName(bookDtoCart2.getName());
					int id=this.bookCartRepo.findByName(bookDtoCart2.getName()).getId();
					cart.setId(id);
					cart.setQuantity(bookDtoCart2.getQuantity());
					this.userRepository.save(user);		
				}
			 }
			 if(found) {
				 return responseHandler.getResponse("add",HttpStatus.OK);
			 }
			 else {
				 return responseHandler.getResponse("add",HttpStatus.OK);
			 }
		}
		else {
			throw new ExistException("Your account LogOut ,Please Login After you can update data");
		}		
	}
	@Override
	public ResponseEntity<List<Cart>> getCart(String token) {
		String email =this.tokenManager.getEmailDecode(token);
		if(this.userRepository.findByEmail(email).isLogin()) {
             List<Cart> cartlist =this.userRepository.findByEmail(email).getCart();
		   return new ResponseEntity<List<Cart>>(cartlist,HttpStatus.OK);		
		}
		throw new ExistException("Your account LogOut ,Please Login After you can update data");		   

	}
	@Override
	public ResponseEntity<Object> getTotal(String token) {
		String email =this.tokenManager.getEmailDecode(token);            
		boolean found =false;
		List<Cart> cartlist =this.userRepository.findByEmail(email).getCart();
		Iterator<Cart>cartIt =cartlist.iterator();
		int totalPrice=0;
		while(cartIt.hasNext()) {
			Cart cart =cartIt.next();
			totalPrice=totalPrice+(cart.getPrice()*cart.getQuantity());
		}
	  return  new ResponseEntity<Object>(totalPrice,HttpStatus.OK);
		
		
	}

	@Override
	public ResponseEntity<Object> removeItem(int token) {
	    this.bookCartRepo.deleteById(token);
		return new ResponseEntity<Object>("deleted",HttpStatus.OK);

	
	}
	@Override
	public ResponseEntity<Object> orderPlace(String token) {
		String email =this.tokenManager.getEmailDecode(token);
		User user =this.userRepository.findByEmail(email);
		 user.setOrderStatus(true);
		this.userRepository.save(user);
	   return new ResponseEntity<Object>("OrderPlace",HttpStatus.OK);
	}
}
