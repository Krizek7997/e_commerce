package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllProducts();
    Product findProductByProductId(Long productId);
}
