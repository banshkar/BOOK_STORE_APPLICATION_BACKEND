package com.bridgelabz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
   public User findByRole(String rolee);
}
