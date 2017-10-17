package com.example.e_rho.architecturetesting;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by eric on 16/10/17.
 */

public abstract class BaseFragment extends Fragment {
    protected static final String TAG = "Eric-BaseFragment";
    protected CentralNavigator mNavigator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (printLogs())
            Log.d(getLogTag(), "onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (printLogs())
            Log.d(getLogTag(),"onAttach");

        try {
            mNavigator = (CentralNavigator)context;
        } catch (ClassCastException ex) {
            Log.d(getLogTag(), "This fragment needs to be attached to a CentralNavigator");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (printLogs())
            Log.d(getLogTag(),"onDetach");
        mNavigator = null;
    }

    public abstract String getLogTag();
    public abstract boolean printLogs();
}
