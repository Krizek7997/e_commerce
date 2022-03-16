package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<String> addOrder();
    ResponseEntity<String> deleteOrder(Long OrderId);
    ResponseEntity<Order> updateOrder(Long OrderId, Order order);
    ResponseEntity<Iterable<Order>> getAllOrders();
    ResponseEntity<Order> getOrderById();

}
