package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.models.Cart;

public interface BookCartRepo extends JpaRepository<Cart, Integer>{
       public Cart findByName(String name);
}
