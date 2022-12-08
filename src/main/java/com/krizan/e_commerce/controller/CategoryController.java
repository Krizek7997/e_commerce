package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CategoryRequest;
import com.krizan.e_commerce.dto.response.CategoryResponse;
import com.krizan.e_commerce.dto.request.updateRequest.CategoryUpdateRequest;
import com.krizan.e_commerce.service.api.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        return new CategoryResponse(categoryService.addCategory(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse updateCategory(
        @PathVariable("id") Long id,
        @RequestBody CategoryUpdateRequest request
    ) {
        return new CategoryResponse(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories().stream()
            .map(CategoryResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryById(@PathVariable("id") Long id) {
        return new CategoryResponse(categoryService.getCategoryById(id));
    }
}
