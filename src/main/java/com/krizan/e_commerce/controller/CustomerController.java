package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Customer;
import com.krizan.e_commerce.service.api.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {}

    @PatchMapping("/{id}")
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer newCustomer) {}

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {}

    @GetMapping
    public void getAllCustomers() {}

    @GetMapping("/{id}")
    public void getCustomerById(@PathVariable("id") Long id) {}
}
