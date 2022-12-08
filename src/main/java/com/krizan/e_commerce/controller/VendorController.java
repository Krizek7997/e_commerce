package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.VendorRequest;
import com.krizan.e_commerce.dto.response.VendorResponse;
import com.krizan.e_commerce.dto.request.updateRequest.VendorUpdateRequest;
import com.krizan.e_commerce.service.api.VendorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
@AllArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorResponse addVendor(@RequestBody VendorRequest request) {
        return new VendorResponse(vendorService.addVendor(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorResponse updateVendor(
        @PathVariable("id") Long id,
        @RequestBody VendorUpdateRequest request
    ) {
        return new VendorResponse(vendorService.updateVendor(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VendorResponse> getAllVendors() {
        return vendorService.getAllVendors().stream()
            .map(VendorResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorResponse getVendorById(@PathVariable("id") Long id) {
        return new VendorResponse(vendorService.getVendorById(id));
    }
}
