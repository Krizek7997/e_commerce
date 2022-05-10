package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.utils.ShoppingCartIdRequest;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id) throws NotFoundException;
    Order addOrder(ShoppingCartIdRequest shoppingCartIdRequest, CustomerRequest customerRequest) throws NotFoundException, IllegalOperationException;
    void cancelOrder(Long id) throws NotFoundException;
    void payForOrder(Long id) throws NotFoundException;
}
