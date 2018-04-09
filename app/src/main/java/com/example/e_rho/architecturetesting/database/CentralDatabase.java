package com.example.e_rho.architecturetesting.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.e_rho.architecturetesting.model.User;

/**
 * Created by e_rho on 1/13/2018.
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class CentralDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
