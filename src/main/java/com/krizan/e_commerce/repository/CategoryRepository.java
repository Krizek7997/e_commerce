package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllCategories();
    Category findCategoryByCategoryId(Long categoryId);
}
