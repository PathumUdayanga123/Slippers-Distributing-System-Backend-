package com.example.demo.service.impl;

import com.example.demo.model.AdminOrders;
import com.example.demo.model.Vendor;
import com.example.demo.repo.AdminOrderRepo;
import com.example.demo.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AdminOrderServiceIMPL {

    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private AdminOrderRepo adminOrderRepo;


    public String saveAdminOrder(Integer  vendorId, Integer size, String slipperType, Integer noOfItems, LocalDate oDate) {
        Vendor vendor = vendorRepo.findById(vendorId).orElse(null);
        if (vendor == null) {
            return "Vendor not found";
        }

        AdminOrders order = new AdminOrders();
        order.setVendor(vendor);
        order.setNoOfItems(noOfItems);
        order.setSize(size);
        order.setSlipperType(slipperType);
        order.setODate(oDate);

        adminOrderRepo.save(order);

        return "Order placed successfully";
    }
}
