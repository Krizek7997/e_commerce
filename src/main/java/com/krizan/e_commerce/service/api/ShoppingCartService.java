package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.ProductIdRequest;
import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.model.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart getShoppingCartById(Long shoppingCartId);
    ShoppingCart addShoppingCart();
    void deleteShoppingCart(Long shoppingCartId);
    ShoppingCart addProductToShoppingCart(Long shoppingCartId, ShoppingCartEntryRequest request);
    void deleteProductFromShoppingCart(Long shoppingCartId, ProductIdRequest request);
}
