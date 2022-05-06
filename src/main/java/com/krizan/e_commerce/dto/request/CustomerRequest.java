package com.krizan.e_commerce.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private String postalCode;
}
