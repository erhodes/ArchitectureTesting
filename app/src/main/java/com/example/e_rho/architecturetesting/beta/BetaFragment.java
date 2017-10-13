package com.example.e_rho.architecturetesting.beta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.SubFragment1;
import com.example.e_rho.architecturetesting.alpha.AlphaFragment;

/**
 * Created by e_rho on 10/11/2017.
 */

public class BetaFragment extends Fragment {
    private static final String TAG = "Eric-Beta";

    private Button mButton;
    private BetaPresenter mBetaPresenter;

    public static BetaFragment newInstance() {
        return new BetaFragment();
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
        this.getParentFragment().getId();
        Log.d(TAG,"launchSubFragment");
        getChildFragmentManager().beginTransaction().addToBackStack(null).replace(getParentFragment().getId(), SubFragment1.newInstance(), "sub").commit();
    }
}
