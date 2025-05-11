package com.example.demo.dto;

import org.jetbrains.annotations.NotNull;

public class EditPasswordDTO {
    @NotNull
    private String email;

    @NotNull
    private String newPassword;

    public EditPasswordDTO(@NotNull String email, String password, @NotNull String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public EditPasswordDTO() {
        newPassword = "";
        email = "";
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }


    public @NotNull String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(@NotNull String newPassword) {
        this.newPassword = newPassword;
    }
}
