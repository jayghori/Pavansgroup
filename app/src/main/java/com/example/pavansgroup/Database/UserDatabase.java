package com.example.pavansgroup.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pavansgroup.Model.User;
import com.example.pavansgroup.dao.UserDao;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class UserDatabase  extends RoomDatabase {

    public static UserDatabase userDatabase;

    public static UserDatabase getInstance(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, "UserDB")
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();

}
