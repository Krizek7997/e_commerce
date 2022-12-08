package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.OrderStatusRequest;
import com.krizan.e_commerce.dto.response.OrderResponse;
import com.krizan.e_commerce.service.api.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders().stream()
            .map(OrderResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrderById(@PathVariable("id") Long id) {
        return new OrderResponse(orderService.getOrderById(id));
    }

    @PostMapping("/create/{cartId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse addOrder(
        @PathVariable("cartId") Long cartId,
        @RequestBody CustomerRequest customerRequest
    ) {
        return new OrderResponse(orderService.addOrder(cartId, customerRequest));
    }

    @PostMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelOrder(@PathVariable("id") Long id) {
        orderService.cancelOrder(id);
    }

    @PostMapping("/{id}/pay")
    @ResponseStatus(HttpStatus.OK)
    public void payForOrder(@PathVariable("id") Long id) {
        orderService.payForOrder(id);
    }

    @PostMapping("/{id}/updateStatus")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderStatus(
        @PathVariable("id") Long id,
        @RequestBody OrderStatusRequest request
    ) {
        orderService.updateOrderStatus(id, request);
    }
}
