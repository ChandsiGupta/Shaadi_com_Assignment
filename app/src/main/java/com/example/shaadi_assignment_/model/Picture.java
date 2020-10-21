package com.example.shaadi_assignment_.model;

public class Picture{
    public String large;
    public String medium;
    public String thumbnail;
    
    @Override
    public String toString() {
        return "Picture{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
    
    public String getLarge() {
        return large;
    }
    
    public void setLarge(String large) {
        this.large = large;
    }
    
    public String getMedium() {
        return medium;
    }
    
    public void setMedium(String medium) {
        this.medium = medium;
    }
    
    public String getThumbnail() {
        return thumbnail;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
