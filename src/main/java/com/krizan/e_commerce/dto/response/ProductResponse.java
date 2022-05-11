package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductResponse {

    private final Long productId;
    private final Long vendorId;
    private final Gender gender;
    private final Long categoryId;
    private final String name;
    private final String description;
    private final String color;
    private final String size;
    private final BigDecimal unitPrice;
    private final Integer discount;
    private final BigDecimal finalUnitPrice;
    private final Integer quantity;

    public ProductResponse(Product product) {
        this.productId = product.getId();
        this.vendorId = product.getVendor().getId();
        this.gender = product.getGender();
        this.categoryId = product.getCategory().getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.color = product.getColor();
        this.size = product.getSize();
        this.unitPrice = product.getUnitPrice();
        this.discount = product.getDiscount();
        this.finalUnitPrice = product.getFinalUnitPrice();
        this.quantity = product.getQuantity();
    }
}
