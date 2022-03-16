package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
