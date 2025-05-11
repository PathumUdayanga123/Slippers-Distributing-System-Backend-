package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "AdminOrders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AdminOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_order_id")
    private Integer adminOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private int size;
    private String slipperType;
    private int noOfItems;
    private LocalDate oDate;

}
