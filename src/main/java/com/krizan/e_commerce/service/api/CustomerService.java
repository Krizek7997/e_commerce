package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<String> addCustomer(Customer customer);
    ResponseEntity<String> deleteCustomer(Long customerId);
    ResponseEntity<Customer> updateCustomer(Long customerId, Customer newCustomer);
    ResponseEntity<Iterable<Customer>> getAllCustomers();
    ResponseEntity<Customer> getCustomerById(Long customerId);

}
