package com.jiezzzo.douyu.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.MenuItem;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseActivity;
import com.jiezzzo.douyu.ui.follow.FollowFragment;
import com.jiezzzo.douyu.ui.homepage.HomePageFragment;
import com.jiezzzo.douyu.ui.live.LiveFragment;
import com.jiezzzo.douyu.ui.user.UserFragment;
import com.jiezzzo.douyu.ui.video.VideoFragment;

import butterknife.BindView;



public class MainActivity extends RxBaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    @BindView(R.id.nav_view)
    NavigationView mNavView;

    private Fragment[] mFragments;
    private int currentTabIndex;

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mNavView.setNavigationItemSelectedListener(this);
        initFragments();
    }

    private void initFragments() {
        HomePageFragment homePageFragment = HomePageFragment.newInstance();
        LiveFragment liveFragment = LiveFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();
        FollowFragment followFragment = FollowFragment.newInstance();
        UserFragment userFragment = UserFragment.newInstance();

        mFragments = new Fragment[] {
                homePageFragment, liveFragment, videoFragment, followFragment, userFragment
        };

        //添加首页Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_layout, homePageFragment)
                .show(homePageFragment).commit();

    }

    private void selectFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments[currentTabIndex]);
        if (!mFragments[index].isAdded()) {
            transaction.add(R.id.content_layout, mFragments[index]);
        }
        transaction.show(mFragments[index]).commit();
        currentTabIndex = index;
    }

    @Override
    protected void firstInit() {
        mNavView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectFragment(0);
                break;
            case R.id.nav_live:
                selectFragment(1);
                break;
            case R.id.nav_video:
                selectFragment(2);
                break;
            case R.id.nav_follow:
                selectFragment(3);
                break;
            case R.id.nav_user:
                selectFragment(4);
                break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(mDrawer.getChildAt(1))) {
            mDrawer.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    public void openDrawer() {
        mDrawer.openDrawer(GravityCompat.START);
    }

}
