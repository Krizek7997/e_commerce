package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<String> addProduct(Product product);
    ResponseEntity<String> deleteProduct(Long productId);
    ResponseEntity<Product> updateProduct(Long productId, Product newProduct);
    ResponseEntity<Iterable<Product>> getAllProducts();
    ResponseEntity<Product> getProductById(Long productId);

}
