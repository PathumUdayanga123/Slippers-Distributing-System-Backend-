package com.example.demo.repo;


import com.example.demo.model.Vendor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {
    @NotNull
    List<Vendor> findAll();

    @Query("SELECT v FROM Vendor v WHERE v.vendorId = :vendorId")
    Vendor findByVendorId(@Param("vendorId") Integer vendorId);

    boolean existsById(@NotNull Integer vendorId);
}
