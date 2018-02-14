package com.example.e_rho.architecturetesting.alpha;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.e_rho.architecturetesting.R;
import com.example.e_rho.architecturetesting.model.User;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */
public class AlphaFragment extends BaseFragment {
    private static final String TAG = "Eric-AF";

    private AlphaViewModel mViewModel;
    private ListView mListView;
    private ArrayAdapter<User> mAdapter;
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

        Log.d(TAG, "onActivityCreated");
        mViewModel.getUser().removeObservers(this);
        mViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null)
                    updateCurrentUser(user);
            }
        });
        mViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null) {
                    updateAllUserList(users);
                }
            }
        });
    }

    @Override
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

    public void updateCurrentUser(User user) {
        Log.d(TAG,"updated! to " + user.getFirstName());
        String text = getString(R.string.signed_in_as) + " " + user.getFirstName() + " " + user.getLastName();
        mTextView.setText(text);
    }

    public void updateAllUserList(List<User> strings) {
        mAdapter.clear();
        mAdapter.addAll(strings);
        mAdapter.notifyDataSetChanged();
    }

    private class UserAdapter extends ArrayAdapter<User> {

        public UserAdapter(@NonNull Context context, @LayoutRes int resource) {
            super(context, resource);
        }
    }
}
