package com.example.demo.service;

import com.example.demo.response.OrderResponse;

import java.time.LocalDate;

public interface AdminOrderService {
    OrderResponse saveAdminOrder(Integer vendorId, Integer size, String slipperType, Integer noOfItems, LocalDate oDate);
}
