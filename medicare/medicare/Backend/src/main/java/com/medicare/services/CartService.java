package com.medicare.services;

import java.util.List;

import com.medicare.model.Cart;

public interface CartService {

    
    public List<Cart> getCartProducts();
    public List<Cart> getCartProductByUsername(String username);
    public Cart getCartProduct(long id);
    public Cart updateCart(long id, Cart cart);
    public void deleteCart(long id);
    public Cart addToCart(Cart cart);

}
