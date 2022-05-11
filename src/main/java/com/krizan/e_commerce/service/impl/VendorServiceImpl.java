package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.VendorRequest;
import com.krizan.e_commerce.dto.updateRequest.VendorUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.repository.VendorRepository;
import com.krizan.e_commerce.service.api.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor addVendor(VendorRequest request) {
        return vendorRepository.save(new Vendor(request));
    }

    @Override
    public void deleteVendor(Long vendorId) throws NotFoundException {
        Vendor vendor = getVendorById(vendorId);
        vendorRepository.delete(vendor);
    }

    @Override
    public Vendor updateVendor(Long vendorId, VendorUpdateRequest request) throws NotFoundException {
        Vendor vendor = getVendorById(vendorId);

        if (request.getName() != null) {
            vendor.setName(request.getName());
        }
        if (request.getCountry() != null) {
            vendor.setCountry(request.getCountry());
        }
        if (request.getAddress() != null) {
            vendor.setAddress(request.getAddress());
        }
        if (request.getPostalCode() != null) {
            vendor.setPostalCode(request.getPostalCode());
        }
        if (request.getEmail() != null) {
            vendor.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            vendor.setPhoneNumber(request.getEmail());
        }
        if (request.getUrl() != null) {
            vendor.setUrl(request.getUrl());
        }

        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor getVendorById(Long vendorId) throws NotFoundException {
        Vendor vendor = vendorRepository.findVendorById(vendorId);
        if (vendor == null) {
            throw new NotFoundException();
        }
        return vendor;
    }
}
