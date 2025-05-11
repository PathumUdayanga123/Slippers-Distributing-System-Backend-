package com.example.demo.repo;

import com.example.demo.dto.UserOrderDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    Optional<Order> findTopByUserOrderByOrderIdDesc(Users user);

    @Query("SELECT new com.example.demo.dto.UserOrderDTO(o.orderId, u.userId, u.f_name, u.l_name, u.dept, o.slipperSize, u.gender, o.orderDate, o.time, o.orderState, o.orderType) FROM Order o JOIN o.user u")
    List<UserOrderDTO> findAllOrderWithUserDetails();


    List<Order> findByUser_UserId(Integer userId);

}
