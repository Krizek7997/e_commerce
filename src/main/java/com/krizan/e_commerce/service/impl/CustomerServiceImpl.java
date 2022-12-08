package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.request.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.repository.CustomerRepository;
import com.krizan.e_commerce.service.api.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerRequest request) {
        return customerRepository.save(new Customer(request));
    }

    @Override
    public Customer updateCustomer(Long customerId, CustomerUpdateRequest request) {
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
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findCustomerById(customerId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email).orElseThrow(NotFoundException::new);
    }
}
