package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CategoryRequest;
import com.krizan.e_commerce.dto.response.CategoryResponse;
import com.krizan.e_commerce.dto.updateRequest.CategoryUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.service.api.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest request) {
        return new ResponseEntity<>(new CategoryResponse(categoryService.addCategory(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("id") Long id,
                                                           @RequestBody CategoryUpdateRequest request) throws NotFoundException {
        return new ResponseEntity<>(new CategoryResponse(categoryService.updateCategory(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) throws NotFoundException {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new CategoryResponse(categoryService.getCategoryById(id)), HttpStatus.OK);
    }
}
