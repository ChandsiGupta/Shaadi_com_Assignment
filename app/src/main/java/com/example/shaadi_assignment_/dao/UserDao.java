package com.example.shaadi_assignment_.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shaadi_assignment_.model.database.User;
import com.example.shaadi_assignment_.model.UserProfile;

import java.util.List;

@Dao
public interface UserDao {
    
    @Query("Select * from user")
    List<User> getUserList();
    
    
    @Query("SELECT * FROM user " +
            "WHERE user.email = :email")
    User isUserExist(String email);
    
    @Insert
    void insertUser(User user);
    
    @Update
    void updatePerson(User user);
    
    @Delete
    void deletePerson(User user);
    
    @Query("SELECT email FROM user " +
            "WHERE user.sync_required = 'true'")
    List<UserProfile> syncProfile();
}
