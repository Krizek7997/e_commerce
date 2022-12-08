package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.CategoryRequest;
import com.krizan.e_commerce.dto.request.updateRequest.CategoryUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.repository.CategoryRepository;
import com.krizan.e_commerce.service.api.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryRequest request) {
        return categoryRepository.save(new Category(request));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = getCategoryById(categoryId);
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryUpdateRequest request) {
        Category category = getCategoryById(categoryId);
        if (request.getName() != null) {
            category.setName(request.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId).orElseThrow(NotFoundException::new);
    }
}
