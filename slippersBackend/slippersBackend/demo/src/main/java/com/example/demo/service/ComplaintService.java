package com.example.demo.service;


import com.example.demo.dto.ComplaintDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.Users;
import com.example.demo.repo.ComplaintRepo;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ComplaintService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private ModelMapper modelMapper;


    public ComplaintDTO saveComplaint(ComplaintDTO complaintDTO) {
        try {
            Users user = userRepo.findByUserId(complaintDTO.getUserID());
            if (user == null) {
                return new ComplaintDTO(complaintDTO.getCid(), "User not found: User with ID " + complaintDTO.getUserID() + " does not exist.", complaintDTO.getUserID(), false);
            }

            Complaint newComplaint = new Complaint();
            newComplaint.setUser(user);
            newComplaint.setCid(complaintDTO.getCid());
            newComplaint.setComplaint(complaintDTO.getComplaint());

            Complaint savedComplaint = complaintRepo.save(newComplaint);

            return new ComplaintDTO(savedComplaint.getCid(), savedComplaint.getComplaint(), user.getUserID(), true);
        } catch (Exception e) {
            return new ComplaintDTO(complaintDTO.getCid(), "Error saving complaint: " + e.getMessage(), complaintDTO.getUserID(), false);
        }
    }

    public ComplaintDTO updateComplaint(ComplaintDTO complaintDTO) {
        try {
            // Fetch the existing complaint by CID
            Complaint existingComplaint = complaintRepo.findById(complaintDTO.getCid())
                    .orElseThrow(() -> new RuntimeException("Complaint not found"));

            // Update fields
            existingComplaint.setComplaint(complaintDTO.getComplaint());

            // Fetch and update the associated user if necessary
            Users user = userRepo.findByUserId(complaintDTO.getUserID());
            if (user == null) {
                throw new RuntimeException("User not found");
            }
            existingComplaint.setUser(user);

            // Save the updated complaint
            Complaint updatedComplaint = complaintRepo.save(existingComplaint);

            // Map the updated complaint entity to a DTO
            return modelMapper.map(updatedComplaint, ComplaintDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error updating complaint", e);
        }
    }

    public String deleteComplaint(int cid) {
        try {
            // Check if the complaint exists before attempting to delete it
            Complaint existingComplaint = complaintRepo.findById(cid)
                    .orElseThrow(() -> new RuntimeException("Complaint not found"));

            // Delete the complaint by cid
            complaintRepo.deleteById(cid);
            return "Complaint deleted";
        } catch (Exception e) {
            throw new RuntimeException("Error deleting complaint", e);
        }
    }

    public List<ComplaintDTO> getAllComplaints() {
        try {
            List<Complaint> complaints = complaintRepo.findAll();
            return complaints.stream()
                    .map(complaint -> modelMapper.map(complaint, ComplaintDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching complaints", e);
        }
    }



}


