package com.medicare.controller;

import java.util.Date;
import java.util.List;

import com.medicare.dto.CartDto;
import com.medicare.model.Cart;
import com.medicare.model.Product;
import com.medicare.model.Purchase;

import com.medicare.services.CartService;
import com.medicare.services.ProductService;
import com.medicare.services.PurchaseService;
import com.medicare.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService purchaseService;


    @PostMapping("/")
    public Cart addCart(@RequestBody CartDto cartDto){
        Cart cart = new Cart();
        cart.setProduct(this.productService.getProductById(cartDto.getProductId()).get());
        cart.setUser(this.userService.getUser(cartDto.getUsername()));
        cart.setQuantity(cartDto.getQuantity());

        List<Cart> carts = this.getCartsByUsername(cartDto.getUsername());
        for (Cart c: carts) {
            if(c.getProduct().equals(this.productService.getProductById(cartDto.getProductId()).get())){
               return cart;
            }
        }
        return this.cartService.addToCart(cart);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable("id") long id){
        return this.cartService.getCartProduct(id);
    }

    @GetMapping("/")
    public List<Cart> getCarts(){
        return this.cartService.getCartProducts();
    }

     @GetMapping("/user/{username}")
    public List<Cart> getCartsByUsername(@PathVariable("username") String username){
        return this.cartService.getCartProductByUsername(username);
    }

    @PutMapping("/{id}")
    public Cart update(@PathVariable("id") long id, @RequestBody Cart cart){
        return this.cartService.updateCart(id,cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") long id){
        this.cartService.deleteCart(id);
    }

    @PutMapping("/{id}/{quantity}")
    public ResponseEntity<?> updateQuantity(@PathVariable("id") long id, @PathVariable("quantity") int quantity){
        Cart cart = this.cartService.getCartProduct(id);
        Product product = cart.getProduct();
        if(product.getStockCount() <= cart.getQuantity()){
          return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cart);
        }
        cart.setQuantity(quantity);
        return ResponseEntity.ok(this.cartService.updateCart(id, cart));
    }

    @GetMapping("/checkout/{username}")
    public void checkout(@PathVariable("username") String username){
        List<Cart> cartItems = this.cartService.getCartProductByUsername(username);

        for(Cart cart:cartItems){
            Purchase purchase = new Purchase();
            purchase.setDate(new Date());
            purchase.setPrice((int)cart.getProduct().getPrice()*cart.getQuantity());
            purchase.setUser(cart.getUser());
            purchase.setProducts(cart.getProduct());
            purchase.setQuantity(cart.getQuantity());
            this.cartService.deleteCart(cart.getId());
            this.purchaseService.addPurchase(purchase);
            Product product = this.productService.getProductById(purchase.getProduct().getId()).get();
            product.setStockCount(product.getStockCount()-purchase.getQuantity());
            this.productService.updateProduct(product.getId(), product);
        }

    }


}
