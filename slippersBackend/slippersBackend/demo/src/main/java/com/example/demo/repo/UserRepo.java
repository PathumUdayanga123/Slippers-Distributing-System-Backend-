package com.example.demo.repo;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUserId(Integer userId);
    Users findByEmailIgnoreCase(String email);

}

