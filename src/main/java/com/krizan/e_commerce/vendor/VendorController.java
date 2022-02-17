package com.krizan.e_commerce.vendor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/vendor")
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @PostMapping
    public ResponseEntity<String> addNewVendor(@RequestBody Vendor vendor) {
        vendorRepository.save(vendor);
        Long id = vendor.getVendorId();
        return new ResponseEntity<>("Vendor has been added with id: " + id + ".", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateVendor(@PathVariable("id") Long id, @RequestBody Vendor newVendor) {
        if (vendorRepository.existsById(id)) {
            Vendor vendor = vendorRepository.findById(id).get();
            vendor.setName(newVendor.getName());
            vendor.setCountry(newVendor.getCountry());
            vendor.setAddress(newVendor.getAddress());
            vendor.setPostalCode(newVendor.getPostalCode());
            vendor.setEmail(newVendor.getEmail());
            vendor.setPhoneNumber(newVendor.getPhoneNumber());
            vendor.setUrl(newVendor.getUrl());
            vendorRepository.save(vendor);
            return new ResponseEntity<>("Vendor with id: " + id + " has been updated.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vendor with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return new ResponseEntity<>("Vendor with id: " + id + " has been deleted.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vendor with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllVendors() {
        Iterable<Vendor> vendors = vendorRepository.findAll();
        return new ResponseEntity<>(vendors.toString(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getVendorById(@PathVariable("id") Long id) {
        if (vendorRepository.existsById(id)) {
            Optional<Vendor> vendor = vendorRepository.findById(id);
            return new ResponseEntity<>(vendor.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vendor with id: " + id + " doesn't exist.",
                    HttpStatus.NOT_FOUND);
        }
    }
}
