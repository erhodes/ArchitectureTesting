package com.example.e_rho.architecturetesting.gamma;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.R;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */
public class GammaFragment extends BaseFragment {
    private static final String TAG = "Eric-Gamma";

    private GammaViewModel mViewModel;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private Button mButton;

    public static GammaFragment newInstance() {
        return new GammaFragment();
    }

    @Override
    public String getLogTag() {
        return TAG;
    }

    @Override
    public boolean printLogs() {
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(GammaViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gamma, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_string);
        mListView.setAdapter(mAdapter);

        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setUserName("TIMOTHY");
            }
        });

        return view;
    }

    public void displayStrings(List<String> strings) {
        mAdapter.clear();
        mAdapter.addAll(strings);
        mAdapter.notifyDataSetChanged();
        mListView.invalidate();
    }

}
