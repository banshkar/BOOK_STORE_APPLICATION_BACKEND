package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bridgelabz.models.BookStore;


public interface BookStoreRepository extends JpaRepository<BookStore, Integer>{
    public BookStore findByName(String name);
} 
