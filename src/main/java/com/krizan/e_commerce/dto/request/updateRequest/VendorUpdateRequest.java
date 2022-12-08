package com.krizan.e_commerce.dto.request.updateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorUpdateRequest {

    private String name;
    private String country;
    private String address;
    private String postalCode;
    private String email;
    private String phoneNumber;
    private String url;
}
