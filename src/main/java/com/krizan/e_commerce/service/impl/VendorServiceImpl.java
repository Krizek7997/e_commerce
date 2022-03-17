package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.repository.VendorRepository;
import com.krizan.e_commerce.service.api.VendorService;
import org.springframework.http.ResponseEntity;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public ResponseEntity<String> addVendor(Vendor vendor) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteVendor(Long VendorId) {
        return null;
    }

    @Override
    public ResponseEntity<Vendor> updateVendor(Long VendorId, Vendor vendor) {
        return null;
    }

    @Override
    public ResponseEntity<Iterable<Vendor>> getAllVendors() {
        return null;
    }

    @Override
    public ResponseEntity<Vendor> getVendorById(Long vendorId) {
        return null;
    }
}
