package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.OrderStatusRequest;
import com.krizan.e_commerce.dto.response.OrderResponse;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.service.api.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new OrderResponse(orderService.getOrderById(id)), HttpStatus.OK);
    }

    @PostMapping("/{cartId}/create")
    public ResponseEntity<OrderResponse> addOrder(@PathVariable("cartId") Long cartId,
                                                  @RequestBody CustomerRequest customerRequest)
            throws NotFoundException, IllegalOperationException {
        return new ResponseEntity<>(new OrderResponse(orderService.addOrder(cartId, customerRequest)),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable("id") Long id) throws NotFoundException {
        orderService.cancelOrder(id);
    }

    @PostMapping("/{id}/pay")
    public void payForOrder(@PathVariable("id") Long id) throws NotFoundException {
        orderService.payForOrder(id);
    }

    @PostMapping("/{id}/updateStatus")
    public void updateOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatusRequest request)
            throws NotFoundException, IllegalOperationException {
        orderService.updateOrderStatus(id, request);
    }
}
