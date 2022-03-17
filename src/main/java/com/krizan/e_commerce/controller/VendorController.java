package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.service.api.VendorService;
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
    public void addVendor(@RequestBody Vendor vendor) {}

    @PatchMapping("/{id}")
    public void updateVendor(@PathVariable("id") Long id, @RequestBody Vendor newVendor) {}

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {}

    @GetMapping
    public void getAllVendors() {}

    @GetMapping("/{id}")
    public void getVendorById(@PathVariable("id") Long id) {}
}
