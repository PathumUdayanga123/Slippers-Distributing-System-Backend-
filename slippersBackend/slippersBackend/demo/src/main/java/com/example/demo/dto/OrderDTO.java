package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter

public class OrderDTO {
    private int orderId;
    private int userId;
    private int slipperSize;
    private LocalDate orderDate;
    private String time;
    private int orderState;
    private String availability;
    private String orderType ;

    public OrderDTO(int orderId, int userId, int slipperSize, LocalDate orderDate, String time, int orderState,
                    String availability, String orderType) {
        this.orderId = orderId;
        this.userId = userId;
        this.slipperSize = slipperSize;
        this.orderDate = orderDate;
        this.time = time;
        this.orderState = orderState;
        this.availability = availability;
        this.orderType = orderType;
    }

    public OrderDTO() {
    }


}




