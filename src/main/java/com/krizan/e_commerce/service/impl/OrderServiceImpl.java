package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.repository.OrderRepository;
import com.krizan.e_commerce.service.api.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
