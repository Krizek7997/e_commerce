package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.ShoppingCartEntry;
import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ShoppingCartEntryResponse {

    private final Long id;
    private final Long productId;
    private final Long vendorId;
    private final Gender gender;
    private final Long categoryId;
    private final String name;
    private final String description;
    private final String color;
    private final String size;
    private final BigDecimal finalUnitPrice;
    private final Integer amount;
    public ShoppingCartEntryResponse(ShoppingCartEntry shoppingCartEntry) {
        this.id = shoppingCartEntry.getId();
        this.productId = shoppingCartEntry.getProduct().getId();
        this.vendorId = shoppingCartEntry.getProduct().getVendor().getId();
        this.gender = shoppingCartEntry.getProduct().getGender();
        this.categoryId = shoppingCartEntry.getProduct().getCategory().getId();
        this.name = shoppingCartEntry.getProduct().getName();
        this.description = shoppingCartEntry.getProduct().getDescription();
        this.color = shoppingCartEntry.getProduct().getColor();
        this.size = shoppingCartEntry.getProduct().getSize();
        this.finalUnitPrice = shoppingCartEntry.getProduct().getFinalUnitPrice();
        this.amount = shoppingCartEntry.getAmount();
    }
}
