package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.VendorRequest;
import com.krizan.e_commerce.dto.updateRequest.VendorUpdateRequest;
import com.krizan.e_commerce.model.Vendor;

import java.util.List;

public interface VendorService {

    Vendor addVendor(VendorRequest request);
    void deleteVendor(Long vendorId);
    Vendor updateVendor(Long vendorId, VendorUpdateRequest request);
    List<Vendor> getAllVendors();
    Vendor getVendorById(Long vendorId);

}
