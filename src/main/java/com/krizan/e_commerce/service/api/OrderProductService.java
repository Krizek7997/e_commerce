package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.OrderProduct;
import org.springframework.http.ResponseEntity;

public interface OrderProductService {

    ResponseEntity<String> addOrderProduct(OrderProduct orderProduct);
    ResponseEntity<String> deleteOrderProduct(Long orderProductId);
    ResponseEntity<OrderProduct> updateOrderProduct(Long orderProductId, OrderProduct newOrderProduct);
    ResponseEntity<Iterable<OrderProduct>> getAllOrderProducts();
    ResponseEntity<OrderProduct> getOrderProductById(Long orderProductId);

}
