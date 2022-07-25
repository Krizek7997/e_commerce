package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(CustomerRequest request);
    Customer updateCustomer(Long customerId, CustomerUpdateRequest request);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long customerId);
    Customer getCustomerByEmail(String email);

}
