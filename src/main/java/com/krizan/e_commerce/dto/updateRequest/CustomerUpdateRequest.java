package com.krizan.e_commerce.dto.updateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateRequest {

    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private String postalCode;
}
