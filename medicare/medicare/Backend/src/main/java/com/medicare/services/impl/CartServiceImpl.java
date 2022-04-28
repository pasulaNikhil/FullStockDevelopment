package com.medicare.services.impl;

import java.util.List;

import com.medicare.model.Cart;
import com.medicare.repository.CartRepository;
import com.medicare.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCartProducts() {
        return this.cartRepository.findAll();
    }

    @Override
    public List<Cart> getCartProductByUsername(String username) {
        return this.cartRepository.findByUser_Username(username);
    }

    @Override
    public Cart getCartProduct(long id) {
        return this.cartRepository.findById(id).get();
    }


    @Override
    public Cart updateCart(long id, Cart cart) {
        cart.setId(id);
        return this.cartRepository.save(cart);
    }

    @Override
    public void deleteCart(long id) {
    
      Cart cart = this.cartRepository.getById(id);
      cart.setUser(null);
      cart.setProduct(null);
      this.cartRepository.delete(cart);
    }

    @Override
    public Cart addToCart(Cart cart) {
        return this.cartRepository.save(cart);
    }
    
}