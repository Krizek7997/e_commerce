package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
