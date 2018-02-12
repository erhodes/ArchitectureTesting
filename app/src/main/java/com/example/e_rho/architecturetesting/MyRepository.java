package com.example.e_rho.architecturetesting;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.example.e_rho.architecturetesting.database.CentralDatabase;
import com.example.e_rho.architecturetesting.database.UserDao;
import com.example.e_rho.architecturetesting.model.User;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by e_rho on 1/12/2018.
 */

public class MyRepository {
    private MutableLiveData<User> mUser;
    private UserDao mUserDao;
    private Executor mExecutor;

    public MyRepository(CentralDatabase centralDatabase) {
        mUserDao = centralDatabase.userDao();

//        mUser = new MutableLiveData<>();
//        mUser.setValue(new User("John", "Doe"));
    }

    public LiveData<User> getUser() {
        return mUserDao.load(1);
    }

    public LiveData<List<User>> getAllUsers() {
        return mUserDao.loadAll();
    }

    public void updateUserName(String name) {
        User user = mUser.getValue();
        user.setFirstName(name);
        mUser.setValue(user);
    }

    public void addUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.d("Eric","saving user " + user);
                mUserDao.save(user);
                return null;
            }
        }.execute();
    }
}
