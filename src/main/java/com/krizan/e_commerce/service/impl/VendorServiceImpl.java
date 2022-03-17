package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.repository.VendorRepository;
import com.krizan.e_commerce.service.api.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public ResponseEntity<String> addVendor(Vendor vendor) {
        vendorRepository.save(vendor);
        Long id = vendor.getVendorId();
        return new ResponseEntity<>("Vendor has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteVendor(Long vendorId) {
        vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalStateException("Vendor with id: " + vendorId + " does not exist."));
        vendorRepository.deleteById(vendorId);
        return new ResponseEntity<>("Category with id: " + vendorId
                + " has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vendor> updateVendor(Long vendorId, Vendor newVendor) {
        Vendor oldVendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalStateException("Vendor with id: " + vendorId + " does not exist."));
        oldVendor.setName(newVendor.getName());
        oldVendor.setCountry(newVendor.getCountry());
        oldVendor.setAddress(newVendor.getAddress());
        oldVendor.setPostalCode(newVendor.getPostalCode());
        oldVendor.setEmail(newVendor.getEmail());
        oldVendor.setPhoneNumber(newVendor.getPhoneNumber());
        oldVendor.setUrl(newVendor.getUrl());

        vendorRepository.save(oldVendor);
        return new ResponseEntity<>(oldVendor, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<Vendor>> getAllVendors() {
        Iterable<Vendor> vendors = vendorRepository.findAll();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vendor> getVendorById(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalStateException("Vendor with id: " + vendorId + " does not exist."));
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
}
