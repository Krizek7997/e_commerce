package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.OrderProduct;
import com.krizan.e_commerce.model.Product;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderProductResponse {

    private final Long orderProductId;
    private final Long orderId;
    private final Product product;
    private final Integer quantity;
    public OrderProductResponse(OrderProduct orderProduct) {
        this.orderProductId = orderProduct.getOrderProductId();
        this.orderId = orderProduct.getOrder().getOrderId();
        this.product = orderProduct.getProduct();
        this.quantity = orderProduct.getQuantity();
    }

    public BigDecimal calcTotalPrice() {
        if (product.getFinalUnitPrice() != null) {
            return product.getFinalUnitPrice().multiply(BigDecimal.valueOf(quantity));
        } else throw new NullPointerException();
    }
}
