package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.utils.ProductIdRequest;

public interface ShoppingCartService {

    ShoppingCart getShoppingCartById(Long shoppingCartId) throws NotFoundException;
    ShoppingCart addShoppingCart();
    void deleteShoppingCart(Long shoppingCartId) throws NotFoundException;
    ShoppingCart addProductToShoppingCart(Long shoppingCartId, ShoppingCartEntryRequest request) throws NotFoundException, IllegalOperationException;
    void deleteProductFromShoppingCart(Long shoppingCartId, ProductIdRequest request) throws NotFoundException, IllegalOperationException;
}
