package com.example.shaadi_assignment_.model;

public class Timezone {
    
    public String offset;
    public String description;
    
    public String getOffset() {
        return offset;
    }
    
    public void setOffset(String offset) {
        this.offset = offset;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Timezone{" +
                "offset='" + offset + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    
}
