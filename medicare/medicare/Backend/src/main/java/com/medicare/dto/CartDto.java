package com.medicare.dto;

public class CartDto {
     private long id;
    private String username;
    private long productId;
    private int quantity;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
  
    public long getProductId() {
        return productId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    
}