package com.example.e_rho.architecturetesting.model;

/**
 * Created by e_rho on 1/12/2018.
 */

public class User {
    private String mFirstName, mLastName;

    public User(String firstName, String lastName){
        mFirstName = firstName;
        mLastName = lastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFirstName() { return mFirstName;}

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
}
