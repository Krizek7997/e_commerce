package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.VendorRequest;
import com.krizan.e_commerce.dto.response.VendorResponse;
import com.krizan.e_commerce.dto.updateRequest.VendorUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.service.api.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<VendorResponse> addVendor(@RequestBody VendorRequest request) {
        return new ResponseEntity<>(new VendorResponse(vendorService.addVendor(request)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorResponse> updateVendor(@PathVariable("id") Long id,
                                               @RequestBody VendorUpdateRequest request) throws NotFoundException {
        return new ResponseEntity<>(new VendorResponse(vendorService.updateVendor(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) throws NotFoundException {
        vendorService.deleteVendor(id);
    }

    @GetMapping
    public List<VendorResponse> getAllVendors() {
        return vendorService.getAllVendors()
                .stream()
                .map(VendorResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorResponse> getVendorById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(new VendorResponse(vendorService.getVendorById(id)), HttpStatus.OK);
    }
}
