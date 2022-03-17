package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.repository.ProductRepository;
import com.krizan.e_commerce.service.api.ProductService;
import org.springframework.http.ResponseEntity;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> addProduct(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long ProductId) {
        return null;
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long ProductId, Product Product) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long productId) {
        return null;
    }
}
