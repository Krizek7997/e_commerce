package com.krizan.e_commerce.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity addNewCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        Integer id = customer.getId();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        if (customerRepository.existsById(id)) {
            //  TODO
            //  Prepisuje mi to id pizdovina
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Customer with id: " + id + " doesn't exist.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Integer id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Customer with id: " + id + " doesn't exist.");
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Integer id) {
        if (customerRepository.existsById(id)) {
            Optional<Customer> customer = customerRepository.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
