package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<String> addCustomer();
    ResponseEntity<String> deleteCustomer(Long CustomerId);
    ResponseEntity<Customer> updateCustomer(Long CustomerId, Customer customer);
    ResponseEntity<Iterable<Customer>> getAllCustomers();
    ResponseEntity<Customer> getCustomerById();

}
