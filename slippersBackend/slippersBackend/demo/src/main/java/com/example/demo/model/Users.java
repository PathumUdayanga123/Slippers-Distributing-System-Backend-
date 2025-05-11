package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Entity
@Table(name="Users")

public class Users {
    @Id
    @NotNull
    @Column(name="UserID", length = 10)
    private Integer userId;

    @NotNull
    @Column(name="UFname", length = 255)
    private String f_name;

    @NotNull
    @Column(name="ULname", length = 255)
    private String l_name;

    @NotNull
    @Column(name="UNIC", length = 12)
    private String nic;

    @NotNull
    @Column(name="UAddress", length = 255)
    private String address;

    @NotNull
    @Column(name="UGender", length = 1)
    private String gender;

    @NotNull
    @Column(name="UType", length = 100)
    private String type;

    @NotNull
    @Column(name="UDept", length = 255)
    private String dept;

    @NotNull
    @Column(name="UEmail", length = 255)
    private String email;

    @NotNull
    @Column(name = "UPassword", length = 255)
    private String password;

    public Users(@NotNull Integer userId, @NotNull String f_name, @NotNull String l_name, @NotNull String nic,
                 @NotNull String address, @NotNull String gender, @NotNull String type, @NotNull String dept,
                 @NotNull String email, @NotNull String password) {
        this.userId = userId;
        this.f_name = f_name;
        this.l_name = l_name;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
        this.type = type;
        this.dept = dept;
        this.email = email;
        this.password = password;
    }

    public Users() {
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

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
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

    @Setter
    @Getter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public Users(List<Order> orders) {
        this.orders = orders;
    }

}
