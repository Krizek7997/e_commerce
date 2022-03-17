package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.service.api.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {}

    @PatchMapping("/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestBody Category newCategory) {}

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {}

    @GetMapping
    public void getAllCategories() {}

    @GetMapping("/{id}")
    public void getCategoryById(@PathVariable("id") Long id) {}
}
