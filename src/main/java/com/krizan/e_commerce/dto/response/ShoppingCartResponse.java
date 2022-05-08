package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.ShoppingCart;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingCartResponse {

    private final Long shoppingCartId;
    private final List<ShoppingCartEntryResponse> products;

    public ShoppingCartResponse(ShoppingCart shoppingCart) {
        this.shoppingCartId = shoppingCart.getShoppingCartId();
        this.products = new ArrayList<>();
        if (shoppingCart.getProducts() != null) {
            shoppingCart.getProducts()
                    .forEach(shoppingCartEntry -> products.add(new ShoppingCartEntryResponse(shoppingCartEntry)));
        }
    }
}
