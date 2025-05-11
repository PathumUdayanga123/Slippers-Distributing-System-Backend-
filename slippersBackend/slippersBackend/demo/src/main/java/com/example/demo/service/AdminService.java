package com.example.demo.service;

import com.example.demo.dto.UserOrderDTO;
import com.example.demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public interface AdminService {
    Logger log = LoggerFactory.getLogger(OrderService.class);
    List<UserOrderDTO> getAllOrder();
}
