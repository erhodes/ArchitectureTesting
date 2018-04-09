package com.example.e_rho.architecturetesting.model;

/**
 * Created by e_rho on 2/14/2018.
 */

public class Attribute {
    protected String mName, mKey;
    protected int mBaseValue, mModifier, mFinalValue;

    public Attribute() {}

    public Attribute (int n) {
        mBaseValue = n;
        calculateFinalValue();
    }
    public Attribute(String name, String key, int baseValue) {
        mName = name;
        mKey = key;
        mBaseValue = baseValue;
        calculateFinalValue();
    }

    public void addModifier(int modifier) {
        mModifier += modifier;
        calculateFinalValue();
    }

    public int getBaseValue() {
        return mBaseValue;
    }

    public void calculateFinalValue() {
        mFinalValue = mBaseValue + mModifier;
    }

    public int getFinalValue() {
        return mFinalValue;
    }
}
