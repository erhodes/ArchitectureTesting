package com.example.e_rho.architecturetesting.alpha;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.CentralNavigator;
import com.example.e_rho.architecturetesting.Injection;
import com.example.e_rho.architecturetesting.R;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */

public class AlphaFragment extends BaseFragment implements AlphaContract.View {
    private static final String TAG = "Eric-AF";

    private AlphaPresenter mAlphaPresenter;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private Button mButton;

    public static AlphaFragment newInstance() {
        return new AlphaFragment();
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
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_alpha, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_string);
        mListView.setAdapter(mAdapter);

        mButton = (Button)view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNavigator.switchToView(CentralNavigator.FRAGMENT_GAMMA);
            }
        });

        mAlphaPresenter = new AlphaPresenter(this, Injection.provideDataModel(getContext()));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAlphaPresenter.start();
    }

    @Override
    public void displayStrings(List<String> strings) {
        mAdapter.clear();
        mAdapter.addAll(strings);
        mAdapter.notifyDataSetChanged();
    }

    private class StringAdapter extends ArrayAdapter<String> {

        public StringAdapter(@NonNull Context context, @LayoutRes int resource) {
            super(context, resource);
        }
    }
}
