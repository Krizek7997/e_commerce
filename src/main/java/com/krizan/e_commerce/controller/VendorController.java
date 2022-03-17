package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.service.api.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<String> addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable("id") Long id,
                                               @RequestBody Vendor newVendor) {
        return vendorService.updateVendor(id, newVendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        return vendorService.deleteVendor(id);
    }

    @GetMapping
    public ResponseEntity<Iterable<Vendor>> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable("id") Long id) {
        return vendorService.getVendorById(id);
    }
}
