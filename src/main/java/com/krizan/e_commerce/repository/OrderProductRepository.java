package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
}
