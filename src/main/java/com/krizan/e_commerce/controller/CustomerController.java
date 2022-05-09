package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.response.CustomerResponse;
import com.krizan.e_commerce.dto.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.service.api.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(new CustomerResponse(customerService.addCustomer(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id,
                                                           @RequestBody CustomerUpdateRequest request) throws NotFoundException {
        return new ResponseEntity<>(new CustomerResponse(customerService.updateCustomer(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) throws NotFoundException {
        customerService.deleteCustomer(id);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new CustomerResponse(customerService.getCustomerById(id)), HttpStatus.OK);
    }
}
