package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
