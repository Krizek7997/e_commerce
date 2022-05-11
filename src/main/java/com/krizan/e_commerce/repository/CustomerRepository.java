package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(Long customerId);
    Customer findCustomerByEmail(String email);
}
