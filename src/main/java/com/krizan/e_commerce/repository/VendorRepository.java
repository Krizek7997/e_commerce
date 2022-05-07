package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

    List<Vendor> findAllVendors();
    Vendor findVendorByVendorId(Long vendorId);
}
