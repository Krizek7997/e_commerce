package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.OrderStatusRequest;
import com.krizan.e_commerce.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order addOrder(Long shoppingCartId, CustomerRequest customerRequest);
    void cancelOrder(Long id);
    void payForOrder(Long id);
    void updateOrderStatus(Long id, OrderStatusRequest request);
}
