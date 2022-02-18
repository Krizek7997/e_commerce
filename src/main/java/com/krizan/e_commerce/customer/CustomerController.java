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
    public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        Long id = customer.getCustomerId();
        return new ResponseEntity<>("Customer has been added with id: " + id + ".", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer newCustomer) {
        if (customerRepository.existsById(id)) {
            Customer customer = customerRepository.findById(id).get();
            customer.setFirstName(newCustomer.getFirstName());
            customer.setSurname(newCustomer.getSurname());
            customer.setEmail(newCustomer.getEmail());
            customer.setPhoneNumber(newCustomer.getPhoneNumber());
            customer.setAddress(newCustomer.getAddress());
            customer.setPostalCode(newCustomer.getPostalCode());
            customerRepository.save(customer);
            return new ResponseEntity<>("Customer with id: " + id + " has been updated.",
                    HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Customer with id: " + id + " doesn't exist.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return new ResponseEntity<>("Customer with id: " + id + " has been deleted.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
        if (customerRepository.existsById(id)) {
            Optional<Customer> customer = customerRepository.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer with id: " + id + " doesn't exist.",
                    HttpStatus.NOT_FOUND);
        }
    }
}
