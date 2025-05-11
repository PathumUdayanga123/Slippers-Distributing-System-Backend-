package com.example.demo.service.impl;

import com.example.demo.dto.EditPasswordDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepo;
import com.example.demo.response.LoginResponse;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserIMPL implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserIMPL.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addUser(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);

        user.setUserID(userDTO.getUserID());
        user.setF_name(userDTO.getF_name());
        user.setL_name(userDTO.getL_name());
        user.setNic(userDTO.getNic());
        user.setAddress(userDTO.getAddress());
        user.setGender(userDTO.getGender());
        user.setType(userDTO.getType());
        user.setDept(userDTO.getDept());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        System.out.println("Mapped User: " + user);

        userRepo.save(user);
        log.info("User added successfully with user ID {}", user.getUserID());
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        Users user = userRepo.findByUserId(loginDTO.getUserId());

        if (user != null) {
            String rawPassword = loginDTO.getPassword();
            String encodedPassword = user.getPassword();

            log.info("Raw password: {}", rawPassword);
            log.info("Encoded password from database: {}", encodedPassword);

            boolean isPasswordRight = passwordEncoder.matches(rawPassword, encodedPassword);

            log.info("Password match result: {}", isPasswordRight);


            if (isPasswordRight) {
                log.info("Login successful for user ID {}", loginDTO.getUserId());
                return new LoginResponse("Login Success", true, user.getType());
            } else {
                log.info("Login failed for user ID {} due to incorrect password", loginDTO.getUserId());
                return new LoginResponse("Invalid credentials. Please try again.", false, null);
            }
        } else {
            log.info("Login failed for user ID {} as user not found", loginDTO.getUserId());
            return new LoginResponse("User not found", false, null);
        }
    }

    @Override
    public LoginResponse updatePassword(EditPasswordDTO editPasswordDTO) {
        log.info("Attempting to update password for email: {}", editPasswordDTO.getEmail());
        String email = editPasswordDTO.getEmail().trim();
        log.info("Trimmed email: {}", email);

        Users user = userRepo.findByEmailIgnoreCase(email);
        log.info("User found: {}", user != null);

        if (user != null) {
            log.info("Found user with email: {}", email);
            user.setPassword(passwordEncoder.encode(editPasswordDTO.getNewPassword()));
            userRepo.save(user);
            log.info("Password updated successfully for email {}", email);
            return new LoginResponse("Password updated successfully", true,null);
        } else {
            log.info("Password update failed for email {} as user not found", email);
            return new LoginResponse("User not found", false, null);
        }
    }

    @Override
    public Users findById(Integer userId) {
        return userRepo.findByUserId(userId);
    }
}
