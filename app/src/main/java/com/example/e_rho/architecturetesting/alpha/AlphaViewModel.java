package com.example.e_rho.architecturetesting.alpha;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.e_rho.architecturetesting.MyApplication;
import com.example.e_rho.architecturetesting.MyRepository;
import com.example.e_rho.architecturetesting.model.User;

import java.util.List;

/**
 * Created by e_rho on 1/12/2018.
 */

public class AlphaViewModel extends ViewModel {
    private MyRepository mRepository;

    public AlphaViewModel() {
        mRepository = MyApplication.getRepository();
    }

    public LiveData<User> getUser() {
        return mRepository.getUser();
    }

    public LiveData<List<User>> getAllUsers() {
        return mRepository.getAllUsers();
    }
}
