package com.medicare.services.impl;

import java.util.List;

import com.medicare.model.Purchase;
import com.medicare.repository.PurchaseRepository;
import com.medicare.services.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{


    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase addPurchase(Purchase purchase) {
        
        return this.purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchase(long id) {
        return this.purchaseRepository.findById(id).get();
    }

    @Override
    public List<Purchase> getPurchases() {
        return this.purchaseRepository.findAll();
    }

    @Override
    public List<Purchase> getPurchasesByUser(String username) {
        return this.purchaseRepository.findByUser_Username(username);
    }
    

}
