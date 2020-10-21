package com.example.shaadi_assignment_.model;

public class Id{
    public String name;
    
    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String value;
}
