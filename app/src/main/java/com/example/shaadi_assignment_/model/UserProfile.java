package com.example.shaadi_assignment_.model;

public class UserProfile {
    public String email;
    public String status;
    
    @Override
    public String toString() {
        return "profile{" +
                "email=" + email +
                ", status='" + status + '\'' +
                '}';
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
}
