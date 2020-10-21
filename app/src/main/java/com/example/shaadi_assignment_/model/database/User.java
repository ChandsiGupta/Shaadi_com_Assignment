package com.example.shaadi_assignment_.model.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "first")
    private String first;
    @ColumnInfo(name = "last")
    private String last;
    @ColumnInfo(name = "gender")
    private String gender;
    @ColumnInfo(name = "age")
    private int age;
    
    public boolean getSyncRequired() {
        return syncRequired;
    }
    
    public void setSyncRequired(boolean syncRequired) {
        this.syncRequired = syncRequired;
    }
    
    @ColumnInfo(name = "sync_required")
    private boolean syncRequired;
    
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
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getThumbnail() {
        return thumbnail;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    @ColumnInfo(name = "thumbnail")
    private String thumbnail;
    
    @ColumnInfo(name = "status")
    private String status;
    
    @ColumnInfo(name = "street")
    private String street;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public User(String email, String first, String last, String gender, int age, String thumbnail, String street, String status, boolean syncRequired) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.age = age;
        this.thumbnail = thumbnail;
        this.status = status;
        this.street = street;
        this.syncRequired = syncRequired;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
