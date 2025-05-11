package com.example.demo.dto;


import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;
import org.jetbrains.annotations.NotNull;

@Data


public class UserDTO {
    @NotNull
    private Integer userId;

    @NotNull
    private String f_name;

    @NotNull
    private String l_name;

    @NotNull
    private String nic;

    @NotNull
    private String address;

    @NotNull
    private String gender;

    @NotNull
    private String type;

    @NotNull
    private String dept;

    @NotNull
    private String email;

    @NonNull
    @NotNull
    private String password;

    public UserDTO(@NotNull Integer userId, @NotNull String f_name, @NotNull String l_name, @NotNull String nic,
                   @NotNull String address, @NotNull String gender, @NotNull String dept, @NotNull String type,
                   @NotNull String email, @NotNull String password) {
        this.userId = userId;
        this.f_name = f_name;
        this.l_name = l_name;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
        this.dept = dept;
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
        userId = 0;
        f_name = "";
        l_name = "";
        nic = "";
        address = "";
        gender = "";
        type = "";
        dept = "";
        email = "";
        password = "";
    }

    public @NotNull Integer getUserID() {
        return userId;
    }

    public void setUserID(@NotNull Integer userID) {
        this.userId = userID;
    }

    public @NotNull String getF_name() {
        return f_name;
    }

    public void setF_name(@NotNull String f_name) {
        this.f_name = f_name;
    }

    public @NotNull String getL_name() {
        return l_name;
    }

    public void setL_name(@NotNull String l_name) {
        this.l_name = l_name;
    }

    public @NotNull String getNic() {
        return nic;
    }

    public void setNic(@NotNull String nic) {
        this.nic = nic;
    }

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public @NotNull String getGender() {
        return gender;
    }

    public void setGender(@NotNull String gender) {
        this.gender = gender;
    }

    public @NotNull String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        this.type = type;
    }

    public @NotNull String getDept() {
        return dept;
    }

    public void setDept(@NotNull String dept) {
        this.dept = dept;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NonNull @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull @NotNull String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}