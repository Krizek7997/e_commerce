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
    public ResponseEntity addNewVendor(@RequestBody Vendor vendor) {
        vendorRepository.save(vendor);
        Long id = vendor.getVendorId();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateVendor(@PathVariable("id") Long id, @RequestBody Vendor newVendor) {
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
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Vendor with id: " + id + " doesn't exist.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVendor(@PathVariable Long id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Vendor with id: " + id + " doesn't exist.");
        }
    }

    @GetMapping
    public ResponseEntity getAllVendors() {
        Iterable<Vendor> vendors = vendorRepository.findAll();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getVendorById(@PathVariable("id") Long id) {
        if (vendorRepository.existsById(id)) {
            Optional<Vendor> vendor = vendorRepository.findById(id);
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
