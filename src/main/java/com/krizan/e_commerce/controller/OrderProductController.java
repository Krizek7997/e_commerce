package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.OrderProduct;
import com.krizan.e_commerce.service.api.OrderProductService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.addOrderProduct(orderProduct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable("id") Long id,
                                                           @RequestBody OrderProduct newOrderProduct) {
        return orderProductService.updateOrderProduct(id, newOrderProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderProduct(@PathVariable Long id) {
        return orderProductService.deleteOrderProduct(id);
    }

    @GetMapping
    public ResponseEntity<Iterable<OrderProduct>> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProduct> getOrderProductById(@PathVariable("id") Long id) {
        return orderProductService.getOrderProductById(id);
    }
}
