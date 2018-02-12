package com.example.e_rho.architecturetesting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.e_rho.architecturetesting.alpha.AlphaFragment;
import com.example.e_rho.architecturetesting.beta.BetaFragment;
import com.example.e_rho.architecturetesting.delta.DeltaFragment;
import com.example.e_rho.architecturetesting.delta.DeltaSubfragment;
import com.example.e_rho.architecturetesting.gamma.GammaFragment;
import com.example.e_rho.architecturetesting.wrapper.WrapperFragment;

public class MainActivity extends AppCompatActivity implements CentralNavigator {
    private static final String TAG = "Eric-Main";

    private BottomNavigationView mBottomNavView;
    private AlphaFragment mAlphaFragment;
    private BetaFragment mBetaFragment;
    private WrapperFragment mBetaWrapper;
    private WrapperFragmentNavigator mBetaNavigator;
    private GammaFragment mGammaFragment;
    private DeltaFragment mDeltaFragment;
    private WrapperFragment mDeltaWrapper;
    private WrapperFragmentNavigator mDeltaNavigator;
    
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // don't reselect
            Log.d("Eric","onNavigationItemSelected " + item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Eric","MainActivity onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            Log.d("Eric","this is a weird restart, with lingering fragments: " + getSupportFragmentManager().getFragments().size());
        }

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
//        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        initializeFragments();

        mBottomNavView = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Eric","MainActivity onResume");
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 1 && mBetaNavigator.onBackPressed()) {
            return;
        } else if (mViewPager.getCurrentItem() == 3 && mDeltaNavigator.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    protected void initializeFragments() {
        // look for an existing alpha fragment
        AlphaFragment alphaFragment = (AlphaFragment) getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 0));
        if (alphaFragment != null) {
            Log.d(TAG,"found an old alpha fragment, will try using it");
            mAlphaFragment = alphaFragment;
        } else {
            mAlphaFragment = AlphaFragment.newInstance();
        }

        WrapperFragment betaWrapper = (WrapperFragment) getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 1));
        if (betaWrapper != null) {
            Log.d(TAG,"found an old beta wrapper, using it");
            mBetaWrapper = betaWrapper;
        } else {
            mBetaWrapper = new WrapperFragment();
        }
        mBetaFragment = BetaFragment.newInstance();
        mBetaNavigator = new WrapperFragmentNavigator(mBetaFragment);
        mBetaWrapper.setNavigator(mBetaNavigator);

        GammaFragment gammaFragment = (GammaFragment) getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 2));
        if (gammaFragment != null) {
            Log.d(TAG,"found an old gamma fragment, will try using it");
            mGammaFragment = gammaFragment;
        } else {
            mGammaFragment = GammaFragment.newInstance();
        }
        Log.d(TAG,"gamma presenter assigned");

        WrapperFragment deltaWrapper = (WrapperFragment) getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 3));
        if (deltaWrapper != null) {
            Log.d(TAG,"found an old delta fragment, will try using it");
            mDeltaWrapper = deltaWrapper;
        } else {
            mDeltaWrapper = new WrapperFragment();
        }
        mDeltaFragment = DeltaFragment.newInstance();
        mDeltaNavigator = new WrapperFragmentNavigator(mDeltaFragment);
        mDeltaWrapper.setNavigator(mDeltaNavigator);
    }

    @NonNull
    private String getFragmentTag(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }

    @Override
    public void switchToView(int viewPosition) {
        mViewPager.setCurrentItem(viewPosition);
    }

    @Override
    public void launchBetaSubFragment1() {
        mBetaWrapper.addFragment(new SubFragment1());
    }

    @Override
    public void launchBetaSubFragment2() {
        mBetaWrapper.addFragment(new SubFragment2());
    }

    @Override
    public void launchDeltaSubFragment() {
        mDeltaWrapper.addFragment(new DeltaSubfragment());
    }

    @Override
    public void launchAdapterSubFragment() {
        // this requires a FragmentStatePagerAdapter to work
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(3);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return mAlphaFragment;
            } else if (position == 1) {
                return mBetaWrapper;
            } else if (position == 2) {
                return mGammaFragment;
            } else if (position == 3) {
                return mDeltaWrapper;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
