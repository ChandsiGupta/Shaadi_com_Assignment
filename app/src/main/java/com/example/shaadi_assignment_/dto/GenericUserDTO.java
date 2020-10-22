package com.example.shaadi_assignment_.dto;

public class GenericUserDTO {
    public String gender;
    public String first;
    public String last;
    public String email;
    public int age;
    public String status;
    
    public String getThumbnail() {
        return thumbnail;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    public String thumbnail;
    
    @Override
    public String toString() {
        return "GenericUser{" +
                "gender='" + gender + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
    
    public String location;
    
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getFirst() {
        return first;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public String getLast() {
        return last;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
