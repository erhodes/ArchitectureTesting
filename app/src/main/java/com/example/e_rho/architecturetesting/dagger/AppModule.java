package com.example.e_rho.architecturetesting.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.e_rho.architecturetesting.MyRepository;
import com.example.e_rho.architecturetesting.database.CentralDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eric on 12/03/18.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    CentralDatabase provideCentralDatabase(Context context) {
        return Room.databaseBuilder(context, CentralDatabase.class, "database-name").build();
    }

    @Provides
    @Singleton
    MyRepository provideMyRepository(CentralDatabase centralDatabase) {
        return new MyRepository(centralDatabase);
    }
}
