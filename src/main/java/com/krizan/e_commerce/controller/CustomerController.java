package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import com.krizan.e_commerce.dto.response.CustomerResponse;
import com.krizan.e_commerce.dto.request.updateRequest.CustomerUpdateRequest;
import com.krizan.e_commerce.service.api.CustomerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse addCustomer(@RequestBody CustomerRequest request) {
        return new CustomerResponse(customerService.addCustomer(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse updateCustomer(
        @PathVariable("id") Long id,
        @RequestBody CustomerUpdateRequest request
    ) {
        return new CustomerResponse(customerService.updateCustomer(id, request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers().stream()
            .map(CustomerResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getCustomerById(@PathVariable("id") Long id) {
        return new CustomerResponse(customerService.getCustomerById(id));
    }
}
