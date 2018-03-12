package com.example.e_rho.architecturetesting.gamma;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.e_rho.architecturetesting.MyApplication;
import com.example.e_rho.architecturetesting.MyRepository;
import com.example.e_rho.architecturetesting.model.User;

import javax.inject.Inject;

/**
 * Created by e_rho on 1/12/2018.
 */

public class GammaViewModel extends ViewModel {
    @Inject MyRepository mRepository;

    public GammaViewModel() {
        MyApplication.getComponent().inject(this);
    }

    public LiveData<User> getUser() {
        return mRepository.getUser();
    }

    public void addUser(User user) {
        mRepository.addUser(user);
    }
}
