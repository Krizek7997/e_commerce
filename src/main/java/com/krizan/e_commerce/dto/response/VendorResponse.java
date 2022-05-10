package com.krizan.e_commerce.dto.response;

import com.krizan.e_commerce.model.Vendor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VendorResponse {

    private final Long vendorId;
    private final String name;
    private final String country;
    private final String address;
    private final String postalCode;
    private final String email;
    private final String phoneNumber;
    private final String url;
    private final List<ProductResponse> products;

    public VendorResponse(Vendor vendor) {
        this.vendorId = vendor.getVendorId();
        this.name = vendor.getName();
        this.country = vendor.getCountry();
        this.address = vendor.getAddress();
        this.postalCode = vendor.getPostalCode();
        this.email = vendor.getEmail();
        this.phoneNumber = vendor.getPhoneNumber();
        this.url = vendor.getUrl();
        this.products = new ArrayList<>();
        if (vendor.getProducts() != null) {
            vendor.getProducts().forEach(product -> products.add(new ProductResponse(product)));
        }
    }
}
