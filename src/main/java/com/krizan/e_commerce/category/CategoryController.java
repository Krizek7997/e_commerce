package com.krizan.e_commerce.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository;}

    @PostMapping
    public ResponseEntity<String> addNewCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        Long id = category.getCategoryId();
        return new ResponseEntity<>("Category has been added with id: " + id + ".", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id, @RequestBody Category newCategory) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.findById(id).get();
            category.setName(newCategory.getName());
            categoryRepository.save(category);
            return new ResponseEntity<>("Category with id: " + id + " has been updated.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>("Category with id: " + id + "has been deleted.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") Long id) {
        if (categoryRepository.existsById(id)) {
            Optional<Category> category = categoryRepository.findById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category with id: " + id + " doesn't exist.",
                    HttpStatus.NOT_FOUND);
        }
    }
}
