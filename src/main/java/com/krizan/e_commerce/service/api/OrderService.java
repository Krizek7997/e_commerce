package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<String> addOrder(Order order);
    ResponseEntity<String> deleteOrder(Long orderId);
    ResponseEntity<Order> updateOrder(Long orderId, Order newOrder);
    ResponseEntity<Iterable<Order>> getAllOrders();
    ResponseEntity<Order> getOrderById(Long orderId);

}
