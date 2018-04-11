package com.example.e_rho.architecturetesting.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by e_rho on 1/12/2018.
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private HashMap<String, Attribute> attributes;
    private String firstName, lastName;

    public User(String firstName, String lastName, HashMap<String, Attribute> attributes){
        this.firstName = firstName;
        this.lastName = lastName;
        this.attributes = attributes;
    }

    public String toString() {
        return String.format(Locale.CANADA,"%d: %s %s. Strength %d", uid, firstName, lastName, attributes.get("str").getFinalValue());
    }

    public String getFullName() {
        return firstName + " " + lastName;
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

    public HashMap<String, Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, Attribute> attributes) {
        this.attributes = attributes;
    }
}
