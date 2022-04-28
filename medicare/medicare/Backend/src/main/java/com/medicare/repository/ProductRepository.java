package com.medicare.repository;

import java.util.List;

import com.medicare.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product>findAllByCategory_Id(int id);

    public List<Product> findByNameContainingIgnoreCase(String query);
}
