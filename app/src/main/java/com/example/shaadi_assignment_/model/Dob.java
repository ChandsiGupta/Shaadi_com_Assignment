package com.example.shaadi_assignment_.model;

import java.util.Date;

public class Dob{
    public Date date;
    public int age;
    
    @Override
    public String toString() {
        return "Dob{" +
                "date=" + date +
                ", age=" + age +
                '}';
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
