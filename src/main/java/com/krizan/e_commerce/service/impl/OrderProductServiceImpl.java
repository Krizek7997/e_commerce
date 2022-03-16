package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.OrderProduct;
import com.krizan.e_commerce.repository.OrderProductRepository;
import com.krizan.e_commerce.service.api.OrderProductService;
import org.springframework.http.ResponseEntity;

public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public ResponseEntity<String> addOrderProduct() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOrderProduct(Long OrderProductId) {
        return null;
    }

    @Override
    public ResponseEntity<OrderProduct> updateOrderProduct(Long OrderProductId, OrderProduct orderProduct) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<OrderProduct>> getAllOrderProducts() {
        return null;
    }

    @Override
    public ResponseEntity<OrderProduct> getOrderProductById() {
        return null;
    }
}
