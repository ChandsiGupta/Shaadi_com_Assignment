package com.example.shaadi_assignment_.model;

public class Coordinates {
    public String latitude;
    public String longitude;
    
    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
    
    public String getLongitude() {
        return longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}
