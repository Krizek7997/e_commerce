package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.service.api.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {}

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product newProduct) {}

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {}

    @GetMapping
    public void getAllProducts() {}

    @GetMapping("/{id}")
    public void getProductById(@PathVariable("id") Long id) {}
}
