package com.krizan.e_commerce.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartEntryRequest {

    private Long productId;
    private Integer quantity;
}
