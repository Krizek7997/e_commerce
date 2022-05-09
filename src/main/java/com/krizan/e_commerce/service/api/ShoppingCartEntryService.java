package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.ShoppingCartEntry;

public interface ShoppingCartEntryService {

    ShoppingCartEntry getShoppingCartEntryById(Long id) throws NotFoundException;
    ShoppingCartEntry addShoppingCartEntry(ShoppingCartEntryRequest request) throws NotFoundException;
    void deleteShoppingCartEntry(Long id) throws NotFoundException;
}
