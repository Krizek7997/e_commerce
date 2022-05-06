package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {

    private final Long categoryId;
    private final String name;

    public CategoryResponse(Category category) {
        this.categoryId = category.getCategoryId();
        this.name = category.getName();
    }
}
