package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.repository.CustomerRepository;
import com.krizan.e_commerce.service.api.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(CustomerRequest request) {
        return customerRepository.save(new Customer(request));
    }

    @Override
    public void deleteCustomer(Long customerId) throws NotFoundException {
        Customer customer = getCustomerById(customerId);
        customerRepository.delete(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, CustomerUpdateRequest request) throws NotFoundException {
        Customer customer = getCustomerById(customerId);

        if (request.getFirstName() != null) {
            customer.setFirstName(request.getFirstName());
        }
        if (request.getSurname() != null) {
            customer.setSurname(request.getSurname());
        }
        if (request.getEmail() != null) {
            customer.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            customer.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getAddress() != null) {
            customer.setAddress(request.getAddress());
        }
        if (request.getPostalCode() != null) {
            customer.setPostalCode(request.getPostalCode());
        }

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public Customer getCustomerById(Long customerId) throws NotFoundException {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        if (customer == null) {
            throw new NotFoundException();
        }
        return customer;
    }
}
