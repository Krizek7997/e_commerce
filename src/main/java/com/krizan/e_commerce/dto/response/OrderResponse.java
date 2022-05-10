package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.utils.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class OrderResponse {

    private final Long orderId;
    private final CustomerResponse customer;
    private final ShoppingCartResponse shoppingCart;
    private final LocalDateTime dateCreated;
    private final Integer numberOfProducts;
    private final BigDecimal orderPrice;
    private final OrderStatus status;

    public OrderResponse(Order order) {
        this.orderId = order.getOrderId();
        this.customer = new CustomerResponse(order.getCustomer());
        this.shoppingCart = new ShoppingCartResponse(order.getShoppingCart());
        this.dateCreated = order.getDateCreated();
        this.numberOfProducts = order.getNumberOfProducts();
        this.orderPrice = order.getTotalOrderPrice();
        this.status = order.getStatus();
    }

}
