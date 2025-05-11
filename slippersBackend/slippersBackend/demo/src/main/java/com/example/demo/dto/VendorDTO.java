package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@Data

public class VendorDTO {
    private Integer vendorId;
    private String vendorName;
    private String address;
    private String email;
    private String contactNo;

    public VendorDTO(Integer vendorId, String vendorName, String address, String email, String contactNo) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
    }

    public VendorDTO() {
    }

}
