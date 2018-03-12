package com.example.e_rho.architecturetesting.dagger;

import com.example.e_rho.architecturetesting.MyApplication;
import com.example.e_rho.architecturetesting.alpha.AlphaViewModel;
import com.example.e_rho.architecturetesting.gamma.GammaViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by eric on 12/03/18.
 */
@Component(modules = {ActivityModule.class, AppModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApplication> {
    void inject(AlphaViewModel alphaViewModel);
    void inject(GammaViewModel gammaViewModel);
}
