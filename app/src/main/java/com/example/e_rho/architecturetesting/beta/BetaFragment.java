package com.example.e_rho.architecturetesting.beta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.R;

/**
 * Created by e_rho on 10/11/2017.
 */

public class BetaFragment extends BaseFragment {
    public static final String TAG = "Eric-Beta";

    private Button mButton;

    public static BetaFragment newInstance() {
        return new BetaFragment();
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
        View view = inflater.inflate(R.layout.fragment_beta, container, false);

        mButton = (Button)view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSubFragment();
            }
        });

        return view;
    }

    private void launchSubFragment() {
        mNavigator.launchBetaSubFragment1();
    }
}
