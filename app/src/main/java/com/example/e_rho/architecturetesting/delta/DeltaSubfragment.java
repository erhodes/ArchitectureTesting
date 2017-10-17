package com.example.e_rho.architecturetesting.delta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_rho.architecturetesting.R;

/**
 * Created by eric on 17/10/17.
 */

public class DeltaSubfragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub1, container, false);


        return view;
    }
}
