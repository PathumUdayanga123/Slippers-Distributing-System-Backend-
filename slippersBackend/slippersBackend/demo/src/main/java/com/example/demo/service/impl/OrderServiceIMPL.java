package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.Users;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.response.OrderResponse;
import com.example.demo.service.OrderService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIMPL implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceIMPL.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    @Transactional
    public OrderResponse saveOrder(Integer userId, int slipperSize, LocalDate orderDate, String time) {
        log.info("Attempting to save order: userId={}, slipperSize={}, orderDate={}, time={}", userId, slipperSize, orderDate, time);

        Users user = userRepo.findByUserId(userId);
        if (user == null) {
            log.warn("User with ID {} not found", userId);
            return new OrderResponse("User not found", false, null, 0);
        }

        log.debug("User found: {}", user);

        Optional<Order> lastOrderOpt = orderRepo.findTopByUserOrderByOrderIdDesc(user);
        int newOrderState = lastOrderOpt.map(order -> order.getOrderState() + 1).orElse(1);

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setSlipperSize(slipperSize);
        newOrder.setOrderDate(orderDate);
        newOrder.setTime(time);
        newOrder.setOrderState(newOrderState);
        log.debug("Order state calculated: {}", newOrderState);

        String orderType = newOrderState > 2 ? "Paid Order" : "Free Order";
        newOrder.setOrderType(orderType);

        newOrder.setAvailability("Pending");

        log.debug("Order details before save: orderState={}, orderType={}, availability={}", newOrderState, newOrder.getOrderType(), newOrder.getAvailability());

        orderRepo.save(newOrder);

        log.info("Order placed successfully for user ID {} with order state {}, orderType={}, availability={}", userId, newOrderState, newOrder.getOrderType(), newOrder.getAvailability());

        return new OrderResponse("Order placed successfully", true, newOrder.getOrderType(), newOrder.getOrderState());

    }

    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepo.findByUser_UserId(userId);
    }


    @Override
    public String deleteOrder(Integer orderId){
        if (orderRepo.existsById(orderId)){
            orderRepo.deleteById(orderId);
            return " Order Deleted" ;
        }
        else{
            return "Order do not Exist";
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }


    @Override
    public Optional<Order> findById(Integer orderId) {
        return orderRepo.findById(orderId);
    }

    @Override
    public void updateAvailability(Integer orderId, String availability) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setAvailability(availability);
        orderRepo.save(order);
    }


}