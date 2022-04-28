package com.medicare.repository;

import java.util.List;

import com.medicare.model.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
     public List<Purchase> findByUser_Username(String username);
}
