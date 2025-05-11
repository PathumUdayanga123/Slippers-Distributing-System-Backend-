package com.example.demo.repo;

import com.example.demo.model.AdminOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdminOrderRepo extends JpaRepository<AdminOrders, Integer> {

    List<AdminOrders> findByVendor_VendorId(Integer vendorId);

}
