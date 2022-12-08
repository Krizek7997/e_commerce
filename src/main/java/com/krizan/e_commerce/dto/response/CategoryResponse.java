package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Category;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryResponse {

    private final Long categoryId;
    private final String name;
    private final List<ProductResponse> products;

    public CategoryResponse(Category category) {
        this.categoryId = category.getId();
        this.name = category.getName();
        this.products = new ArrayList<>();
        if (category.getProducts() != null) {
            category.getProducts().forEach(product -> products.add(new ProductResponse(product)));
        }
    }
}
