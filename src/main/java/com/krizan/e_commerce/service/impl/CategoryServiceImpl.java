package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.repository.CategoryRepository;
import com.krizan.e_commerce.service.api.CategoryService;
import org.springframework.http.ResponseEntity;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<String> addCategory() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long CategoryId) {
        return null;
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long CategoryId, Category category) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        return null;
    }

    @Override
    public ResponseEntity<Category> getCategoryById() {
        return null;
    }
}
