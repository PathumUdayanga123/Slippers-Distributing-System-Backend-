package com.example.demo.controller;

import com.example.demo.service.impl.AdminOrderServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/admin")

public class AdminOrdersController {

    @Autowired
    private AdminOrderServiceIMPL adminOrderServiceIMPL;

    @PostMapping("/saveAdminOrder")
    public String saveAdminOrder(
            @RequestParam int vendorId,
            @RequestParam int size,
            @RequestParam String slipperType,
            @RequestParam int noOfItems,
            @RequestParam LocalDate oDate
    ) {

        return adminOrderServiceIMPL.saveAdminOrder(vendorId, size, slipperType, noOfItems, oDate);
    }
}
