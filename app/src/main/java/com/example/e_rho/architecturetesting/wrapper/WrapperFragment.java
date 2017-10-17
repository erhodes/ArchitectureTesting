package com.example.e_rho.architecturetesting.wrapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.WrapperFragmentNavigator;

/**
 * Created by eric on 16/10/17.
 */

public class WrapperFragment extends Fragment {
    private static final String TAG = "Eric-WrapperFragment";
    private WrapperFragmentNavigator mNavigator;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wrapper, container, false);

        return view;
    }

    public void setNavigator(WrapperFragmentNavigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "start");
        mNavigator.onAttach(this);
    }

    public void addFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment, null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void popFragment() {
        Log.d(TAG,"pop!");
        getChildFragmentManager().popBackStack();
    }
}
