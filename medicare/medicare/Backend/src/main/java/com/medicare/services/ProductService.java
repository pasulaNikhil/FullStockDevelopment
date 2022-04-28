package com.medicare.services;

import java.util.List;
import java.util.Optional;

import com.medicare.model.Product;

public interface ProductService {

    public List<Product> getAlProducts();
    
    public Product addProduct(Product product);
    
    public Product updateProduct(long id, Product product);
    
    public void deleteProduct(long id);

    public Optional<Product> getProductById(long id);
    
    public List<Product> getProductByCategoryId(int id);

    public List<Product> getProductsByQuery(String query);
    
}
