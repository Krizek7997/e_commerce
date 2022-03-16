package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
