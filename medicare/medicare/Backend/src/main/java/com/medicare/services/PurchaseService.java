package com.medicare.services;

import java.util.List;

import com.medicare.model.Purchase;

public interface PurchaseService {

    public Purchase addPurchase(Purchase purchase);
    public Purchase getPurchase(long id);
    public List<Purchase> getPurchases();
    public List<Purchase> getPurchasesByUser(String username);
    
}

