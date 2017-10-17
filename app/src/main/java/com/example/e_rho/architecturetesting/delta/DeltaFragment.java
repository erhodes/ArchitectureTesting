package com.example.e_rho.architecturetesting.delta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.R;

/**
 * Created by eric on 16/10/17.
 */

public class DeltaFragment extends BaseFragment {
    private static final String TAG = "Eric-DeltaFragment";

    private Button mButton;

    public static DeltaFragment newInstance() {
        return new DeltaFragment();
    }

    @Override
    public String getLogTag() {
        return TAG;
    }

    @Override
    public boolean printLogs() {
        return false;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delta, container, false);

        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNavigator.launchDeltaSubFragment();
            }
        });

        return view;
    }

}
