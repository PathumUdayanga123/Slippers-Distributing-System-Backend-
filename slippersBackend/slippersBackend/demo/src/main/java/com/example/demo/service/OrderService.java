package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.response.OrderResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderResponse saveOrder(Integer userId, int slipperSize, LocalDate orderDate, String time);

    List<Order> getAllOrders();

    String deleteOrder(Integer orderId);

    List<Order> getOrdersByUserId(Integer userId);

    void updateAvailability(Integer orderId, String availability);

    Optional<Order> findById(Integer orderId);
}
