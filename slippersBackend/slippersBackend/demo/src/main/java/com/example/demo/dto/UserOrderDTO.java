package com.example.demo.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class UserOrderDTO {
    private Integer orderId;
    private Integer userId;
    private String f_name;
    private String l_name;
    private String dept;
    private Integer slipperSize;
    private String gender;
    private LocalDate orderDate;
    private String  time;
    private Integer orderState;
    private String orderType;

    public UserOrderDTO(Integer orderId, Integer userId, String f_name, String l_name, String dept, Integer slipperSize,
                        String gender, LocalDate orderDate, String time, Integer orderState, String orderType) {
        this.orderId = orderId;
        this.userId = userId;
        this.f_name = f_name;
        this.l_name = l_name;
        this.dept = dept;
        this.slipperSize = slipperSize;
        this.gender = gender;
        this.orderDate = orderDate;
        this.time = time;
        this.orderState = orderState;
        this.orderType = orderType;
    }

    public UserOrderDTO() {
    }

}
