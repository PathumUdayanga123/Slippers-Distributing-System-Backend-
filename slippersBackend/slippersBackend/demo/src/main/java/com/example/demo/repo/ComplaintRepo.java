package com.example.demo.repo;

import com.example.demo.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

}
