package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.OrderStatusRequest;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final CustomerService customerService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Order addOrder(Long shoppingCartId, CustomerRequest customerRequest) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(shoppingCartId);
        if (shoppingCart.getProducts().isEmpty()) {
            throw new IllegalOperationException();
        }

        Customer customer = customerService.getCustomerByEmail(customerRequest.getEmail());
        if (customer == null) {
            customer = customerService.addCustomer(customerRequest);
        }

        Order order = new Order(shoppingCart, customer);

        if (customer.getOrders() != null) {
            customer.getOrders().add(order);
        }

        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = getOrderById(id);
        order.setStatus(OrderStatus.CANCELLED);
        var cartEntries = order.getShoppingCart().getProducts();
        for (var entry: cartEntries) {
            entry.getProduct().setQuantity(entry.getProduct().getQuantity() + entry.getAmount());
        }
        orderRepository.save(order);
    }

    @Override
    public void payForOrder(Long id) {
        Order order = getOrderById(id);
        order.setStatus(OrderStatus.CONFIRMED);
        orderRepository.save(order);
    }

    @Override
    public void updateOrderStatus(Long id, OrderStatusRequest request) {
        Order order = getOrderById(id);
        OrderStatus newStatus = null;
        for (var status: OrderStatus.values()) {
            if (request.getStatus().equals(status)) {
                newStatus = request.getStatus();
                break;
            }
        }
        if (newStatus == null) throw new IllegalOperationException();
        order.setStatus(newStatus);
        orderRepository.save(order);
    }
}
