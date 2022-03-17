package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.repository.OrderRepository;
import com.krizan.e_commerce.service.api.OrderService;
import org.springframework.http.ResponseEntity;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<String> addOrder(Order order) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOrder(Long OrderId) {
        return null;
    }

    @Override
    public ResponseEntity<Order> updateOrder(Long OrderId, Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long orderId) {
        return null;
    }
}
