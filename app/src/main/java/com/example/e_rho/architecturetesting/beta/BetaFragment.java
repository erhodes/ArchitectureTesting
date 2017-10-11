package com.example.e_rho.architecturetesting.beta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.alpha.AlphaFragment;

/**
 * Created by e_rho on 10/11/2017.
 */

public class BetaFragment extends Fragment {
    private BetaPresenter mBetaPresenter;

    public static BetaFragment newInstance() {
        return new BetaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beta, container, false);

        return view;
    }
}
