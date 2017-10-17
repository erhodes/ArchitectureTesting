package com.example.e_rho.architecturetesting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by eric on 17/10/17.
 */

public class SubFragment2 extends Fragment {
    private Button mButton;

    public static SubFragment2 newInstance() {
        return new SubFragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub2, container, false);


        return view;
    }
}
