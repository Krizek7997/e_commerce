package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.ShoppingCartEntry;
import lombok.Getter;

@Getter
public class ShoppingCartEntryResponse {

    private final Long id;
    private final ProductResponse product;
    private final Integer amount;
    public ShoppingCartEntryResponse(ShoppingCartEntry shoppingCartEntry) {
        this.id = shoppingCartEntry.getId();
        this.product = new ProductResponse(shoppingCartEntry.getProduct());
        this.amount = shoppingCartEntry.getAmount();
    }
}
