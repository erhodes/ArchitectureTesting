package com.example.e_rho.architecturetesting.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by e_rho on 10/11/2017.
 */

public class DataModel {
    ArrayList<String> mStrings;
    private Context mContext;
    private ArrayList<CallbackListener> mListeners;
    private int mViewState;

    public static final int VIEW_STATE_SUBFRAGMENT1 = 1;

    public DataModel(Context context) {
        mContext = context;
        mStrings = new ArrayList<>();
        mListeners = new ArrayList<>();
        mStrings.add("lightning bolt");
        mStrings.add("fireball");
        mStrings.add("whelming wave");
        mStrings.add("earth strike");
    }

    public void addString(String string) {
        mStrings.add(string);
        notifyStringsChanged();
    }

    public void removeString(String string) {
        mStrings.remove(string);
        notifyStringsChanged();
    }

    public void notifyStringsChanged() {
        for (CallbackListener listener : mListeners) {
            listener.onStringsUpdated();
        }
    }

    public ArrayList<String> getStrings() {
        return mStrings;
    }

    public void addCallbackListener(CallbackListener listener) {
        mListeners.add(listener);
    }

    public void removeCallbackListener(CallbackListener listener) {
        mListeners.remove(listener);
    }

    public void setViewState(int state) {
        mViewState = state;
    }

    public int getViewState() {
        return mViewState;
    }

    public interface CallbackListener {
        void onStringsUpdated();
    }
}
