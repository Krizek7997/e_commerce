package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order getOrderByOrderId(Long id);
}
