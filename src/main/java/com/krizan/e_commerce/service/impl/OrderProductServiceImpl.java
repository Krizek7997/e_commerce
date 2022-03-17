package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.OrderProduct;
import com.krizan.e_commerce.repository.OrderProductRepository;
import com.krizan.e_commerce.service.api.OrderProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public ResponseEntity<String> addOrderProduct(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
        Long id = orderProduct.getOrderProductId();
        return new ResponseEntity<>("OrderProduct has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteOrderProduct(Long orderProductId) {
        orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new IllegalStateException("orderProduct with id: " + orderProductId
                        + " does not exist."));
        orderProductRepository.deleteById(orderProductId);
        return new ResponseEntity<>("Customer with id: " + orderProductId
                + " has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderProduct> updateOrderProduct(Long orderProductId, OrderProduct newOrderProduct) {
        OrderProduct oldOP = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new IllegalStateException("OrderProduct with id: " + orderProductId
                        + " does not exist."));
        oldOP.setOrder(newOrderProduct.getOrder());
        oldOP.setProduct(newOrderProduct.getProduct());
        oldOP.setQuantity(newOrderProduct.getQuantity());

        orderProductRepository.save(oldOP);
        return new ResponseEntity<>(oldOP, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<OrderProduct>> getAllOrderProducts() {
        Iterable<OrderProduct> orderProducts = orderProductRepository.findAll();
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderProduct> getOrderProductById(Long orderProductId) {
        OrderProduct orderProduct = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new IllegalStateException("OrderProduct with id: " + orderProductId
                        + " does not exist."));
        return new ResponseEntity<>(orderProduct, HttpStatus.OK);
    }
}
