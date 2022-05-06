package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Order;
import com.krizan.e_commerce.utils.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponse {

    private final Long orderId;
    private final Long customerId;
    private final List<OrderProductResponse> orderProducts;
    private final LocalDateTime dateCreated;
    private final Integer numberOfProducts;
    private final BigDecimal totalOrderPrice;
    private final OrderStatus status;

    public OrderResponse(Order order) {
        this.orderId = order.getOrderId();
        this.customerId = order.getCustomer().getCustomerId();
        this.orderProducts = new ArrayList<>();
        order.getOrderProducts().forEach(orderProduct -> orderProducts.add(new OrderProductResponse(orderProduct)));
        this.dateCreated = LocalDateTime.parse(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        this.numberOfProducts = orderProducts.size();
        this.totalOrderPrice = calcTotalOrderPrice();
        this.status = order.getStatus();
    }

    private BigDecimal calcTotalOrderPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (var product : orderProducts) {
            total = total.add(product.calcTotalPrice());
        }
        return total;
    }
}
