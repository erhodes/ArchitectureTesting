package com.example.e_rho.architecturetesting.gamma;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.model.User;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */
public class GammaFragment extends BaseFragment {
    private static final String TAG = "Eric-Gamma";

    private GammaViewModel mViewModel;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private User mUser;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(GammaViewModel.class);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG,"onActivityCreated");
        mViewModel.getUser().observe(this, new android.arch.lifecycle.Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mUser = user;
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gamma, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_string);
        mListView.setAdapter(mAdapter);

        Button changeNameButton = (Button) view.findViewById(R.id.button);
        changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setFirstName("TIMOTHY");
                mViewModel.addUser(mUser);
            }
        });

        Button addUserButton = (Button) view.findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("John", "Doe");
                mViewModel.addUser(user);
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
