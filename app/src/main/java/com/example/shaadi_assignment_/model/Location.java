package com.example.shaadi_assignment_.model;

public class Location{
    public Street street;
    public String city;
    public String state;
    public String country;
    public Object postcode;
    public Coordinates coordinates;
    public Timezone timezone;
    @Override
    public String toString() {
        return "Location{" +
                "street=" + street +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postcode=" + postcode +
                ", coordinates=" + coordinates +
                ", timezone=" + timezone +
                '}';
    }
    
    public Street getStreet() {
        return street;
    }
    
    public void setStreet(Street street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public Object getPostcode() {
        return postcode;
    }
    
    public void setPostcode(Object postcode) {
        this.postcode = postcode;
    }
    
    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    public Timezone getTimezone() {
        return timezone;
    }
    
    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }
    
    
}
