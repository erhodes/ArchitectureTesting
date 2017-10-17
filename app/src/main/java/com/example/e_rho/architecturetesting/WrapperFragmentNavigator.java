package com.example.e_rho.architecturetesting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.e_rho.architecturetesting.wrapper.WrapperFragment;

/**
 * Created by eric on 17/10/17.
 */

public class WrapperFragmentNavigator {
    private static final String TAG = "Eric-WrapperNav";

    private Fragment mBaseFragment;
    private WrapperFragment mWrapperFragment;
    private FragmentManager mFragmentManager;

    public WrapperFragmentNavigator (Fragment fragment) {
        mBaseFragment = fragment;
    }

    public void onAttach(WrapperFragment wrapperFragment) {
        mWrapperFragment = wrapperFragment;
        mFragmentManager = wrapperFragment.getChildFragmentManager();
        if (mFragmentManager.getBackStackEntryCount() < 1) {
            mWrapperFragment.addFragment(mBaseFragment);
        }
    }

    public boolean onBackPressed() {
        Log.d(TAG,"wrapper has " + mFragmentManager.getBackStackEntryCount() + " fragments");
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            mWrapperFragment.popFragment();
            return true;
        }
        return false;
    }
}
