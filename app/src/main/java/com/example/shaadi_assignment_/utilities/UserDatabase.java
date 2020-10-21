package com.example.shaadi_assignment_.utilities;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shaadi_assignment_.model.database.User;
import com.example.shaadi_assignment_.dao.UserDao;

@Database(entities = User.class, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    
    private static final String DB_NAME = "user_db";
    
    private static UserDatabase userDatabase;
    
    public static synchronized UserDatabase getInstance(Context context) {
        
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, DB_NAME).allowMainThreadQueries().build();
        }
        return userDatabase;
    }
    
    public abstract UserDao userDao();
}
