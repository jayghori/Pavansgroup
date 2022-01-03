package com.example.pavansgroup.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pavansgroup.Model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM USERTABLE ORDER BY id DESC")
    List<User> getAllUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

}
