package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminOrdersDTO {
    private int adminOrderID;
    private int vendorId;
    private int size;
    private String slipperType;
    private int noOfItems;
    private LocalDate oDate;
}
