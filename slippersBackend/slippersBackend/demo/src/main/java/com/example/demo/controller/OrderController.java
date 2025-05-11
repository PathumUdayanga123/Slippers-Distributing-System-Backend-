package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.response.OrderResponse;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/orders")

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public OrderResponse saveOrder(
            @RequestParam Integer userId,
            @RequestParam int slipperSize,
            @RequestParam LocalDate orderDate,
            @RequestParam String time
    ) {
        log.info("Received request to save order for user ID {}", userId);

        OrderResponse response = orderService.saveOrder(userId, slipperSize, orderDate, time);

        log.info("Order response: {}", response);
        return response;
    }

    @GetMapping("/getOrdersById/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Integer userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        if (orders == null || orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No orders found for userId: " + userId);
        }
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        String response = orderService.deleteOrder(orderId);
        if (response.equals("Order Deleted")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{orderId}/releaseOrder")
    public ResponseEntity<?> releaseOrder(
            @PathVariable Integer orderId) {
        try {
            orderService.updateAvailability(orderId, "received");
            return ResponseEntity.ok().body("Order updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating order: " + e.getMessage());
        }
    }
}

