package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Vendor;
import org.springframework.http.ResponseEntity;

public interface VendorService {

    ResponseEntity<String> addVendor(Vendor vendor);
    ResponseEntity<String> deleteVendor(Long vendorId);
    ResponseEntity<Vendor> updateVendor(Long vendorId, Vendor newVendor);
    ResponseEntity<Iterable<Vendor>> getAllVendors();
    ResponseEntity<Vendor> getVendorById(Long vendorId);

}
