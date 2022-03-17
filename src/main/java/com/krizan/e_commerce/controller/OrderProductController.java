package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.OrderProduct;
import com.krizan.e_commerce.service.api.OrderProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/orderProduct")
public class OrderProductController {

    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @PostMapping
    public void addOrderProduct(@RequestBody OrderProduct orderProduct) {}

    @PatchMapping("/{id}")
    public void updateOrderProduct(@PathVariable("id") Long id, @RequestBody OrderProduct newOrderProduct) {}

    @DeleteMapping("/{id}")
    public void deleteOrderProduct(@PathVariable Long id) {}

    @GetMapping
    public void getAllOrderProducts() {}

    @GetMapping("/{id}")
    public void getOrderProductById(@PathVariable("id") Long id) {}
}
