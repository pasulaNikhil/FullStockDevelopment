package com.medicare.repository;

import com.medicare.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
}
