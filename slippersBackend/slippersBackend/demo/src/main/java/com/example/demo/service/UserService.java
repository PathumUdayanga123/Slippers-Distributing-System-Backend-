package com.example.demo.service;
import com.example.demo.dto.EditPasswordDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users;
import com.example.demo.response.LoginResponse;

public interface UserService {

    void addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
    LoginResponse updatePassword(EditPasswordDTO editPasswordDTO);

    Users findById(Integer userId);
}
