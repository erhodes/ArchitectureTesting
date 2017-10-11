package com.example.e_rho.architecturetesting.gamma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.e_rho.architecturetesting.Injection;
import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.beta.BetaFragment;
import com.example.e_rho.architecturetesting.beta.BetaPresenter;
import com.example.e_rho.architecturetesting.model.DataModel;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */

public class GammaFragment extends Fragment implements GammaContract.View{
    private static final String TAG = "Eric-Gamma";

    private GammaPresenter mGammaPresenter;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private Button mButton;

    public static GammaFragment newInstance() {
        return new GammaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_gamma, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_string);
        mListView.setAdapter(mAdapter);

        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGammaPresenter.onAddString();
            }
        });

        mGammaPresenter = new GammaPresenter(this, Injection.provideDataModel(getContext()));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mGammaPresenter.start();
    }

    @Override
    public void displayStrings(List<String> strings) {
        mAdapter.clear();
        mAdapter.addAll(strings);
        mAdapter.notifyDataSetChanged();
        mListView.invalidate();
    }

}
