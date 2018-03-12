package com.example.e_rho.architecturetesting.dagger;

import com.example.e_rho.architecturetesting.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by eric on 12/03/18.
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();
}
