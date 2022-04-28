package com.medicare.services.impl;

import java.util.List;
import java.util.Optional;

import com.medicare.model.Category;
import com.medicare.repository.CategoryRepository;
import com.medicare.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    
     @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category){
       return this.categoryRepository.save(category);
    }
     public Category updateCategory(Category category){
       return this.categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return this.categoryRepository.findAll();
    }

    public void deleteCategory(int id){
        this.categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategory(int id){
       return this.categoryRepository.findById(id);
    }
}