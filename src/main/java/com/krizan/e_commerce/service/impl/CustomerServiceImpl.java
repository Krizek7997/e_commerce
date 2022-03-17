package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.repository.CustomerRepository;
import com.krizan.e_commerce.service.api.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<String> addCustomer(Customer customer) {
        customerRepository.save(customer);
        Long id = customer.getCustomerId();
        return new ResponseEntity<>("Customer has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + customerId + " does not exist."));
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>("Customer with id: " + customerId
                + " has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Long customerId, Customer newCustomer) {
        Customer oldCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + customerId + " does not exist."));
        oldCustomer.setFirstName(newCustomer.getFirstName());
        oldCustomer.setSurname(newCustomer.getSurname());
        oldCustomer.setEmail(newCustomer.getEmail());
        oldCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setPostalCode(newCustomer.getPostalCode());
        oldCustomer.setOrders(newCustomer.getOrders());

        customerRepository.save(oldCustomer);
        return new ResponseEntity<>(oldCustomer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + customerId + " does not exist."));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
