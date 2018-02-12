package com.example.e_rho.architecturetesting.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.e_rho.architecturetesting.model.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by e_rho on 1/13/2018.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE uid = :userId")
    LiveData<User> load(int userId);

    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAll();

    @Insert(onConflict = REPLACE)
    void save(User user);
}
