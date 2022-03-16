package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<String> addCategory();
    ResponseEntity<String> deleteCategory(Long CategoryId);
    ResponseEntity<Category> updateCategory(Long CategoryId, Category category);
    ResponseEntity<Iterable<Category>> getAllCategories();
    ResponseEntity<Category> getCategoryById();

}
