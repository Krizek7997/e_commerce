package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.dto.response.ProductResponse;
import com.krizan.e_commerce.dto.updateRequest.ProductUpdateRequest;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.utils.Amount;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(new ProductResponse(productService.addProduct(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductUpdateRequest request
    ) {
        return new ResponseEntity<>(new ProductResponse(productService.updateProduct(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts()
                .stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ProductResponse(productService.getProductById(id)), HttpStatus.OK);
    }

    @PostMapping("/{id}/addQuantity")
    public ResponseEntity<ProductResponse> addProductQuantity(@PathVariable("id") Long id, @RequestBody Amount amount) {
        return new ResponseEntity<>(new ProductResponse(productService.addProductQuantity(id, amount)), HttpStatus.OK);
    }

    @PostMapping("/{id}/removeQuantity")
    public ResponseEntity<ProductResponse> removeProductQuantity(@PathVariable("id") Long id, @RequestBody Amount amount) {
        return new ResponseEntity<>(new ProductResponse(productService.removeProductQuantity(id, amount)), HttpStatus.OK);
    }

    @PostMapping("/{id}/setDiscount")
    public ResponseEntity<ProductResponse> setDiscount(@PathVariable("id") Long id, @RequestBody Amount amount) {
        return new ResponseEntity<>(new ProductResponse(productService.setDiscount(id, amount)), HttpStatus.OK);
    }
}
