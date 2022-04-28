package com.medicare.repository;

import java.util.List;

import com.medicare.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    
    public List<Cart> findByUser_Username(String username);

}
