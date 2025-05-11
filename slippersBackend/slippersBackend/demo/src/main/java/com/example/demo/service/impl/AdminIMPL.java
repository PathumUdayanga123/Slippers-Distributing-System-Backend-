package com.example.demo.service.impl;

import com.example.demo.dto.UserOrderDTO;
import com.example.demo.model.Order;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminIMPL implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminIMPL.class);

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public List<UserOrderDTO> getAllOrder() {
        return orderRepo.findAllOrderWithUserDetails();

    }

    private UserOrderDTO convertToDTO(Order order) {
        log.info("Converting Order to DTO: {}", order.getOrderId());
        UserOrderDTO dto = new UserOrderDTO();

        try {
            dto.setOrderId(order.getOrderId());
            dto.setUserId(order.getUser().getUserID());
            dto.setF_name(order.getUser().getF_name());
            dto.setL_name(order.getUser().getL_name());
            dto.setDept(order.getUser().getDept());
            dto.setSlipperSize(order.getSlipperSize());
            dto.setGender(order.getUser().getGender());
            dto.setOrderDate(order.getOrderDate());
            dto.setTime(order.getTime());
            dto.setOrderState(order.getOrderState());
            dto.setOrderType(order.getOrderType());

        } catch (Exception e) {
            log.error("Error converting Order to DTO: {}", e.getMessage());
            throw e;
        }

        log.info("Converted DTO: {}", dto);
        return dto;
    }



}

