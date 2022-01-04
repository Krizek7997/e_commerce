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
    public ResponseEntity addNewCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        Long id = category.getId();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateCategory(@PathVariable("id") Long id, @RequestBody Category newCategory) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.findById(id).get();
            category.setName(newCategory.getName());
            categoryRepository.save(category);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Category with id: " + id + " doesn't exist.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Category with id: " + id + " doesn't exist.");
        }
    }

    @GetMapping
    public ResponseEntity getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") Long id) {
        if (categoryRepository.existsById(id)) {
            Optional<Category> category = categoryRepository.findById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
