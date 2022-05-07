package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllProducts();
    Product findProductByProductId(Long productId);
}
