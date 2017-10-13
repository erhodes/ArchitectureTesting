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
import com.example.e_rho.architecturetesting.gamma.GammaFragment;
import com.example.e_rho.architecturetesting.gamma.GammaPresenter;
import com.example.e_rho.architecturetesting.model.DataModel;

public class MainActivity extends AppCompatActivity implements CentralNavigator {
    private static final String TAG = "Eric-Main";

    private BottomNavigationView mBottomNavView;
    private AlphaFragment mAlphaFragment;
    private BetaFragment mBetaFragment;
    private GammaFragment mGammaFragment;
    private ViewPager mViewPager;
    private DataModel mDataModel;

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

        mDataModel = Injection.provideDataModel(this);

        if (savedInstanceState != null) {
            Log.d("Eric","this is a wierd restart, with lingering fragments: " + getSupportFragmentManager().getFragments().size());
        }

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
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

        mBetaFragment = BetaFragment.newInstance();

        GammaFragment gammaFragment = (GammaFragment) getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 2));
        if (gammaFragment != null) {
            Log.d(TAG,"found an old gamma fragment, will try using it");
            mGammaFragment = gammaFragment;
        } else {
            mGammaFragment = GammaFragment.newInstance();
        }

        GammaPresenter gammaPresenter = new GammaPresenter(mGammaFragment, mDataModel);
        mGammaFragment.setPresenter(gammaPresenter);
    }

    @NonNull
    private String getFragmentTag(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }

    @Override
    public void switchToView(int viewPosition) {
        mViewPager.setCurrentItem(viewPosition);
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
                return mBetaFragment;
            } else if (position == 2) {
                return mGammaFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
