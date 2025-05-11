package com.example.demo.dto;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public class LoginDTO {
    private Integer userId;
    @NotNull
    @NonNull
    private String password;

    public LoginDTO(int userId, @NotNull String password) {
        this.userId = userId;
        this.password = password;
    }

    public LoginDTO() {
        password = "";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }
}
