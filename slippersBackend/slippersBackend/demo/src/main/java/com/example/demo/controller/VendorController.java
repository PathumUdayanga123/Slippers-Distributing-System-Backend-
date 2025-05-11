package com.example.demo.controller;

import com.example.demo.dto.VendorDTO;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/v1/")

public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/getVendors")
    public List<VendorDTO> getVendors(){
        return vendorService.getAllVendors();
    }


    @PostMapping("/addVendor")
    public VendorDTO saveVendor (@RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendor(vendorDTO);
    }

    @PutMapping("/updateVendor")
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.updateVendor(vendorDTO);
    }

    @DeleteMapping("/deleteVendor/{vendorId}")
    public String deleteVendor(@PathVariable int vendorId) {
        vendorService.deleteVendorById(vendorId);
        return "Vendor Deleted";
    }


}
