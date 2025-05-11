package com.example.demo.service;

import com.example.demo.dto.VendorDTO;
import com.example.demo.model.Vendor;
import com.example.demo.repo.VendorRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class VendorService {
    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<VendorDTO> getAllVendors(){
        List<Vendor>vendorList= vendorRepo.findAll();
        return modelMapper.map(vendorList,new TypeToken<List<VendorDTO>>(){}.getType());
    }

    public VendorDTO saveVendor(VendorDTO vendorDTO) {
        vendorRepo.save(modelMapper.map(vendorDTO, Vendor.class));
        return vendorDTO;
    }

    public VendorDTO updateVendor(VendorDTO vendorDTO) {
        vendorRepo.save(modelMapper.map(vendorDTO, Vendor.class));
        return vendorDTO;
    }

    public void deleteVendorById(int vendorId) {
        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendorRepo.delete(vendor);
    }
}
