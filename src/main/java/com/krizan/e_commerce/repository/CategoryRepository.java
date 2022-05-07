package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllCategories();
    Category findCategoryByCategoryId(Long categoryId);
}
