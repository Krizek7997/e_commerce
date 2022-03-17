package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<String> addCategory(Category category);
    ResponseEntity<String> deleteCategory(Long categoryId);
    ResponseEntity<Category> updateCategory(Long categoryId, Category newCategory);
    ResponseEntity<Iterable<Category>> getAllCategories();
    ResponseEntity<Category> getCategoryById(Long categoryId);

}
