package com.example.e_rho.architecturetesting.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Locale;

/**
 * Created by e_rho on 1/12/2018.
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String firstName, lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format(Locale.CANADA,"%d: %s %s", uid, firstName, lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() { return firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
