package com.krizan.e_commerce.dto.request;

import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    private Long vendor;
    private Gender gender;
    private Long category;
    private String name;
    private String description;
    private String color;
    private String size;
    private BigDecimal unitPrice;
    private Integer discount;
    private Integer quantity;
}
