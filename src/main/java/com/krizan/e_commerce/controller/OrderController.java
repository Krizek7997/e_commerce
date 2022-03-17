package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.service.api.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {}

    @PatchMapping("/{id}")
    public void updateOrder(@PathVariable("id") Long id, @RequestBody Order newOrder) {}

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {}

    @GetMapping
    public void getAllOrders() {}

    @GetMapping("/{id}")
    public void getOrderById(@PathVariable("id") Long id) {}
}
