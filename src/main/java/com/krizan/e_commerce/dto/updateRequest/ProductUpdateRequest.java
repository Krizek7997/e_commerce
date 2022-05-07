package com.krizan.e_commerce.dto.updateRequest;

import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdateRequest {

    private Gender gender;
    private Category category;
    private String name;
    private String description;
    private String color;
    private String size;
    private BigDecimal unitPrice;
    private Integer quantity;
}
