package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.response.CustomerResponse;
import com.krizan.e_commerce.dto.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.service.api.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(new CustomerResponse(customerService.addCustomer(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id,
                                                           @RequestBody CustomerUpdateRequest request) {
        return new ResponseEntity<>(new CustomerResponse(customerService.updateCustomer(id, request)), HttpStatus.OK);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new CustomerResponse(customerService.getCustomerById(id)), HttpStatus.OK);
    }
}
