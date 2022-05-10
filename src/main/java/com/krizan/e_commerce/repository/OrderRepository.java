package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllOrders();
    Order getOrderByOrderId(Long id);
}
