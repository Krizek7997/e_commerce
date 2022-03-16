package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.model.Vendor;
import org.springframework.http.ResponseEntity;

public interface VendorService {

    ResponseEntity<String> addVendor();
    ResponseEntity<String> deleteVendor(Long VendorId);
    ResponseEntity<Vendor> updateVendor(Long VendorId, Vendor vendor);
    ResponseEntity<Iterable<Vendor>> getAllVendors();
    ResponseEntity<Vendor> getVendorById();

}
