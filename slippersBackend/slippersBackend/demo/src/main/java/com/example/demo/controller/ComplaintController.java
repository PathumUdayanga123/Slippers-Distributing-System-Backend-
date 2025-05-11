package com.example.demo.controller;


import com.example.demo.dto.ComplaintDTO;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/v1/")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/addComplaint")
    public ResponseEntity<?> saveComplaint(@RequestBody ComplaintDTO complaintDTO) {
        try {
            ComplaintDTO savedComplaint = complaintService.saveComplaint(complaintDTO);
            return ResponseEntity.ok(savedComplaint);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving complaint: " + e.getMessage());
        }
    }

    @PutMapping("/updateComplaint")
    public ResponseEntity<?> updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
        try {
            ComplaintDTO updatedComplaint = complaintService.updateComplaint(complaintDTO);
            return ResponseEntity.ok(updatedComplaint);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating complaint: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteComplaint/{cid}")
    public ResponseEntity<?> deleteComplaint(@PathVariable int cid) {
        try {
            String response = complaintService.deleteComplaint(cid);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting complaint: " + e.getMessage());
        }
    }

    @GetMapping("/getComplaints")
    public ResponseEntity<?> getComplaints() {
        try {
            List<ComplaintDTO> complaints = complaintService.getAllComplaints();
            return ResponseEntity.ok(complaints);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching complaints: " + e.getMessage());
        }
    }



}
