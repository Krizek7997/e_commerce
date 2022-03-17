package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.repository.CategoryRepository;
import com.krizan.e_commerce.service.api.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<String> addCategory(Category category) {
        categoryRepository.save(category);
        Long id = category.getCategoryId();
        return new ResponseEntity<>("Category has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category with id: " + categoryId + " does not exist."));
        categoryRepository.deleteById(categoryId);
        return new ResponseEntity<>("Category with id: " + categoryId
                + "has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long categoryId, Category newCategory) {
        Category oldCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category with id: " + categoryId + " does not exist."));
        oldCategory.setName(newCategory.getName());
        categoryRepository.save(oldCategory);
        return new ResponseEntity<>(oldCategory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category with id: " + categoryId + " does not exist."));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
