package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.utils.ProductIdRequest;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> getAllShoppingCarts();
    ShoppingCart getShoppingCartById(Long shoppingCartId) throws NotFoundException;
    ShoppingCart addShoppingCart();
    void deleteShoppingCart(Long shoppingCartId) throws NotFoundException;
    ShoppingCart addProductToShoppingCart(Long shoppingCartId, ProductIdRequest request) throws NotFoundException;
    void deleteProductFromShoppingCart(Long shoppingCartId, ProductIdRequest request);
}
