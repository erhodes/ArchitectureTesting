package com.example.e_rho.architecturetesting.alpha;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e_rho.architecturetesting.BaseFragment;
import com.example.e_rho.architecturetesting.CentralNavigator;
import com.example.e_rho.architecturetesting.Injection;
import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.model.User;

import java.util.List;
import java.util.Observer;

/**
 * Created by e_rho on 10/11/2017.
 */
public class AlphaFragment extends BaseFragment {
    private static final String TAG = "Eric-AF";

    private AlphaViewModel mViewModel;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private Button mButton;
    private TextView mTextView;

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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(AlphaViewModel.class);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG,"onActivityCreated");
        mViewModel.getUser().observe(this, new android.arch.lifecycle.Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                update(user);
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_alpha, container, false);

        mListView = (ListView)view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_string);
        mListView.setAdapter(mAdapter);
        mTextView = (TextView)view.findViewById(R.id.textView3);

        mButton = (Button)view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNavigator.switchToView(CentralNavigator.FRAGMENT_GAMMA);
            }
        });

        return view;
    }

    public void update(User user) {
        Log.d(TAG,"updated! to " + user.getFirstName());
        String text = getString(R.string.signed_in_as) + " " + user.getFirstName() + " " + user.getLastName();
        mTextView.setText(text);
    }

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
