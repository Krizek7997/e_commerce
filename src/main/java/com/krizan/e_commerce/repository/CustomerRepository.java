package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllCustomers();
    Customer findCustomerByCustomerId(Long customerId);
    Customer findCustomerByEmail(String email);
}
