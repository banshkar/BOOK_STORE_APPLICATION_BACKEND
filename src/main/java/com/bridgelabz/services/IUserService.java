package com.bridgelabz.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.dto.BookDtoCart;
import com.bridgelabz.dto.Login;
import com.bridgelabz.dto.RegisterDto;

import com.bridgelabz.models.BookStore;
import com.bridgelabz.models.Cart;

public interface IUserService {
    public ResponseEntity<Object> addUser(RegisterDto registerDto);
    public ResponseEntity<Object> update(String token,RegisterDto registerDto);
    public ResponseEntity<Object> delete(String token);
    public ResponseEntity<Object> getDetails(String token);
    public ResponseEntity<Object> login(Login login);
    public ResponseEntity<Object> Logout(String token);
    public ResponseEntity<Object> addBookToCart(String token,List<BookDtoCart> bookDtoCart );
    public ResponseEntity  <List<Cart>> getCart(String token);
    public ResponseEntity  <Object> getTotal(String token);
    public ResponseEntity  <Object> removeItem(int name);
    public ResponseEntity  <Object> orderPlace(String token);
}
