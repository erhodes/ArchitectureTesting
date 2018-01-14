package com.example.e_rho.architecturetesting;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.e_rho.architecturetesting.model.User;

/**
 * Created by e_rho on 1/12/2018.
 */

public class MyRepository {
    private MutableLiveData<User> mUser;

    public MyRepository() {
        mUser = new MutableLiveData<>();
        mUser.setValue(new User("John", "Doe"));
    }

    public LiveData<User> getUser() {
        return mUser;
    }

    public void updateUserName(String name) {
        User user = mUser.getValue();
        user.setFirstName(name);
        mUser.setValue(user);
    }
}
