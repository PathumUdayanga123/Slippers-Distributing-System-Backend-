package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@Data


public class Vendor {
    @Id
    @Column(name="vendorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;

    @Column(nullable = false)
    private String vendorName;

    private String address;
    private String email;
    private String contactNo;

    @Getter
    @Setter
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdminOrders> adminOrders = new ArrayList<>();

    public Vendor(Integer vendorId, String vendorName, String address, String email, String contactNo, List<AdminOrders> adminOrders) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.adminOrders = adminOrders;

    }

    public Vendor() {
    }


}
