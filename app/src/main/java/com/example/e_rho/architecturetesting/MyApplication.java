package com.example.e_rho.architecturetesting;

import android.app.Application;

/**
 * Created by e_rho on 1/12/2018.
 */

public class MyApplication extends Application {
    private static MyRepository sRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        sRepository = new MyRepository();
    }

    public static MyRepository getRepository() {
        return sRepository;
    }
}
