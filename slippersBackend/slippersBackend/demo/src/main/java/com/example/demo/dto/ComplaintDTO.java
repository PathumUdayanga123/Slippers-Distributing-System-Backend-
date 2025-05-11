package com.example.demo.dto;

import lombok.Data;


@Data


public class ComplaintDTO {
    private int cid;
    private String complaint;
    private int userId;
    private boolean success;

    public ComplaintDTO(int cid, String complaint, int userId, boolean success) {
        this.cid = cid;
        this.complaint = complaint;
        this.userId = userId;
        this.success = success;
    }

    public ComplaintDTO() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
        this.success = false;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
