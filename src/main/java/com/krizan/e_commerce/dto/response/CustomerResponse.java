package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomerResponse {

    private final Long customerId;
    private final String firstName;
    private final String surname;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final String postalCode;
    private final List<Long> orders;

    public CustomerResponse(Customer customer) {
        this.customerId = customer.getId();
        this.firstName = customer.getFirstName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.address = customer.getAddress();
        this.postalCode = customer.getPostalCode();
        this.orders = new ArrayList<>();
        if (customer.getOrders() != null) {
            customer.getOrders().forEach(order -> orders.add(order.getId()));
        }
    }
}
