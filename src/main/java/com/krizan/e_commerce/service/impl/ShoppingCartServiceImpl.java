package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.repository.ShoppingCartRepository;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.ShoppingCartService;
import com.krizan.e_commerce.utils.ProductIdRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAllShoppingCarts();
    }

    @Override
    public ShoppingCart getShoppingCartById(Long shoppingCartId) throws NotFoundException {
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByShoppingCartId(shoppingCartId);
        if (shoppingCart == null) {
            throw new NotFoundException();
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart addShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(Long shoppingCartId) throws NotFoundException {
        ShoppingCart shoppingCart = getShoppingCartById(shoppingCartId);
        shoppingCartRepository.delete(shoppingCart);
    }

    @Override
    public ShoppingCart addProductToShoppingCart(Long shoppingCartId, ProductIdRequest request) throws NotFoundException {
        ShoppingCart shoppingCart = getShoppingCartById(shoppingCartId);
        return null;
    }

    @Override
    public void deleteProductFromShoppingCart(Long shoppingCartId, ProductIdRequest request) {

    }
}
