package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.repository.OrderRepository;
import com.krizan.e_commerce.service.api.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<String> addOrder(Order order) {
        order.setDateCreated(LocalDateTime
                .parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        order.setNumberOfProducts(order.calcNumberOfProducts());
        order.setTotalOrderPrice(order.calcTotalOrderPrice());
        orderRepository.save(order);
        Long id = order.getOrderId();
        return new ResponseEntity<>("Order has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteOrder(Long orderId) {
        orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id: " + orderId + " does not exist."));
        orderRepository.deleteById(orderId);
        return new ResponseEntity<>("Customer with id: " + orderId
                + " has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> updateOrder(Long orderId, Order newOrder) {
        Order oldOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id: " + orderId + " does not exist."));
        oldOrder.setCustomer(newOrder.getCustomer());
        oldOrder.setOrderProducts(newOrder.getOrderProducts());
        oldOrder.setDateCreated(newOrder.getDateCreated());
        oldOrder.setNumberOfProducts(newOrder.getNumberOfProducts());
        oldOrder.setTotalOrderPrice(newOrder.getTotalOrderPrice());
        oldOrder.setStatus(newOrder.getStatus());

        orderRepository.save(oldOrder);
        return new ResponseEntity<>(oldOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id: " + orderId + " does not exist."));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
