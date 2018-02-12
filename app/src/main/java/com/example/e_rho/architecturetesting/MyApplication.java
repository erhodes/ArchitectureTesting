package com.example.e_rho.architecturetesting;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.e_rho.architecturetesting.database.CentralDatabase;

/**
 * Created by e_rho on 1/12/2018.
 */

public class MyApplication extends Application {
    private static MyRepository sRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        CentralDatabase centralDatabase = Room.databaseBuilder(this, CentralDatabase.class, "database-name").build();

        sRepository = new MyRepository(centralDatabase);
    }

    public static MyRepository getRepository() {
        return sRepository;
    }
}
