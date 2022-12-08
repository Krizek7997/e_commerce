package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.model.ShoppingCartEntry;

public interface ShoppingCartEntryService {

    ShoppingCartEntry getShoppingCartEntryById(Long id);
    ShoppingCartEntry addShoppingCartEntry(
        ShoppingCartEntryRequest request,
        ShoppingCart shoppingCart
    );
    void deleteShoppingCartEntry(Long id);
}
