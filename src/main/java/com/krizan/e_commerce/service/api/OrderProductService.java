package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.OrderProduct;
import org.springframework.http.ResponseEntity;

public interface OrderProductService {

    ResponseEntity<String> addOrderProduct();
    ResponseEntity<String> deleteOrderProduct(Long OrderProductId);
    ResponseEntity<OrderProduct> updateOrderProduct(Long OrderProductId, OrderProduct orderProduct);
    ResponseEntity<Iterable<OrderProduct>> getAllOrderProducts();
    ResponseEntity<OrderProduct> getOrderProductById();

}
