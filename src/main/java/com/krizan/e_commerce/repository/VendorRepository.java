package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Vendor findVendorById(Long vendorId);
}
