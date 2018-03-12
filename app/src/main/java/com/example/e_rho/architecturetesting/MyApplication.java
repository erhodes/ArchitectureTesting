package com.example.e_rho.architecturetesting;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.e_rho.architecturetesting.dagger.AppComponent;
import com.example.e_rho.architecturetesting.dagger.AppModule;
import com.example.e_rho.architecturetesting.dagger.DaggerAppComponent;
import com.example.e_rho.architecturetesting.database.CentralDatabase;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by e_rho on 1/12/2018.
 */

public class MyApplication extends Application implements HasActivityInjector {
    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private static AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mComponent.inject(this);
    }

    public static AppComponent getComponent() {
        return mComponent;
    }
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
