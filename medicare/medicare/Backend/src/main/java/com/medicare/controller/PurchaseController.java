package com.medicare.controller;

import java.util.List;

import com.medicare.model.Purchase;
import com.medicare.services.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public List<Purchase> gPurchases(){
        return this.purchaseService.getPurchases();
    }

    @GetMapping("/{username}")
    public List<Purchase> gPurchaseByUser(@PathVariable("username") String username){
        return this.purchaseService.getPurchasesByUser(username);
    }
    
}

