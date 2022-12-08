package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);
    Optional<Customer> findCustomerByEmail(String email);
}
