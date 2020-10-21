package com.example.shaadi_assignment_.model;

public class Street {
    public int number;
    public String name;
    
    @Override
    public String toString() {
        return "Street{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}