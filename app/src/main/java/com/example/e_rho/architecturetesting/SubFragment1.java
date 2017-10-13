package com.example.e_rho.architecturetesting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by e_rho on 10/12/2017.
 */

public class SubFragment1 extends Fragment {
    private Button mButton;

    public static SubFragment1 newInstance() {
        return new SubFragment1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub1, container, false);

        mButton = (Button)view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO; go to subfragment 2
            }
        });

        return view;
    }
}
