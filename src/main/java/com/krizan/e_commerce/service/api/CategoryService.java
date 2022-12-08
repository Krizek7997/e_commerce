package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.CategoryRequest;
import com.krizan.e_commerce.dto.request.updateRequest.CategoryUpdateRequest;
import com.krizan.e_commerce.model.Category;
import java.util.List;

public interface CategoryService {

    Category addCategory(CategoryRequest request);
    void deleteCategory(Long categoryId);
    Category updateCategory(Long categoryId, CategoryUpdateRequest request);
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);

}
