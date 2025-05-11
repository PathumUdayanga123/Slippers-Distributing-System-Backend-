package com.example.demo.response;

public class OrderResponse {
    private String message;
    private Boolean status;
    private Integer orderState;
    private String orderType;

    public OrderResponse(String message, Boolean status, String orderType, Integer orderState) {
        this.message = message;
        this.status = status;
        this.orderType = orderType;
        this.orderState = orderState;
    }

    public OrderResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
