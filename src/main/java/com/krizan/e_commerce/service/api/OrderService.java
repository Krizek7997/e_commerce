package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.OrderStatusRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id) throws NotFoundException;
    Order addOrder(Long shoppingCartId, CustomerRequest customerRequest) throws NotFoundException, IllegalOperationException;
    void cancelOrder(Long id) throws NotFoundException;
    void payForOrder(Long id) throws NotFoundException;
    void updateOrderStatus(Long id, OrderStatusRequest request) throws NotFoundException, IllegalOperationException;
}
