package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.repository.OrderRepository;
import com.krizan.e_commerce.service.api.CustomerService;
import com.krizan.e_commerce.service.api.OrderService;
import com.krizan.e_commerce.service.api.ShoppingCartService;
import com.krizan.e_commerce.utils.OrderStatus;
import com.krizan.e_commerce.utils.ShoppingCartIdRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final CustomerService customerService;

    public OrderServiceImpl(OrderRepository orderRepository, ShoppingCartService shoppingCartService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.customerService = customerService;
    }

    @Override
    public Order getOrderById(Long id) throws NotFoundException {
        Order order = orderRepository.getOrderByOrderId(id);
        if (order == null) {
            throw new NotFoundException();
        }
        return order;
    }

    @Override
    public Order addOrder(ShoppingCartIdRequest shoppingCartIdRequest, CustomerRequest customerRequest) throws NotFoundException, IllegalOperationException {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(shoppingCartIdRequest.getId());
        if (shoppingCart.getProducts().isEmpty()) {
            throw new IllegalOperationException();
        }
        Customer customer = customerService.addCustomer(customerRequest);
        Order order = new Order(shoppingCart, customer);
        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long id) throws NotFoundException {
        Order order = getOrderById(id);
        order.setStatus(OrderStatus.CANCELLED);
        var cartEntries = order.getShoppingCart().getProducts();
        for (var entry: cartEntries) {
            entry.getProduct().setQuantity(entry.getProduct().getQuantity() + entry.getAmount());
        }
        orderRepository.save(order);
    }

    @Override
    public void payForOrder(Long id) throws NotFoundException {
        Order order = getOrderById(id);
        order.setStatus(OrderStatus.CONFIRMED);
        orderRepository.save(order);
    }
}
