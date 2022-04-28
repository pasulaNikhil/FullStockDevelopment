package com.medicare.services;

import java.util.List;
import java.util.Optional;

import com.medicare.model.Category;

public interface CategoryService {
    
    public Category addCategory(Category category);
    
    public Category updateCategory(Category category);

    public List<Category> getCategories();

    public void deleteCategory(int id);

    public Optional<Category> getCategory(int id);


}
