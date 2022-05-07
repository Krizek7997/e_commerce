package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllCustomers();
    Customer findCustomerByCustomerId(Long customerId);
}
