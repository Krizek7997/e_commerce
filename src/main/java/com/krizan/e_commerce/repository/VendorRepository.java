package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    List<Vendor> findAllVendors();
    Vendor findVendorByVendorId(Long vendorId);
}
