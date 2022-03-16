package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.repository.CustomerRepository;
import com.krizan.e_commerce.service.api.CustomerService;
import org.springframework.http.ResponseEntity;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<String> addCustomer() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long CustomerId) {
        return null;
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Long CustomerId, Customer customer) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return null;
    }

    @Override
    public ResponseEntity<Customer> getCustomerById() {
        return null;
    }
}
