package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Order.findAllOrderWithUserDetails", query = "SELECT o FROM Order o JOIN o.user u")
@Table(name="UserOrders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID", nullable = false)
    @JsonIgnore
    private Users user;

    @Column(name = "SlipperSize")
    private int slipperSize;

    @NotNull
    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "OrderTime")
    private String time;

    @Column(name ="OrderState", nullable=false, columnDefinition = "integer default 0")
    private int orderState;

    @Column(name = "Availability", nullable = false, columnDefinition = "VARCHAR(255) default 'pending'")
    private String availability = "Pending";

    @NotNull
    @Column(name = "OrderType", nullable = false, columnDefinition = "VARCHAR(255) default 'Free Order'")
    private String orderType;


    public @NotNull LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(@NotNull LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public @NotNull String getTime() {
        return time;
    }

    public void setTime(@NotNull String time) {
        this.time = time;
    }

    public @NotNull String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(@NotNull String orderType) {
        this.orderType = orderType;
    }
}
