package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<String> addProduct();
    ResponseEntity<String> deleteProduct(Long ProductId);
    ResponseEntity<Product> updateProduct(Long ProductId, Product Product);
    ResponseEntity<Iterable<Product>> getAllProducts();
    ResponseEntity<Product> getProductById();

}
