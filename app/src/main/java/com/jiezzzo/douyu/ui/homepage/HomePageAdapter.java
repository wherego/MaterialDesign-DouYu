package com.jiezzzo.douyu.ui.homepage;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jiezzzo.douyu.ui.homepage.mobilegame.MobileGameFragment;
import com.jiezzzo.douyu.ui.homepage.onlinegame.OnlineGameFragment;
import com.jiezzzo.douyu.ui.homepage.other.OtherFragment;
import com.jiezzzo.douyu.ui.homepage.recommend.RecommendFragment;
import com.jiezzzo.douyu.ui.homepage.recreation.RecreationFragment;

import java.util.List;

/**
 * Created by oaier on 2017/4/25.
 */

public class HomePageAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;
    private Fragment[] mFragments;

    public HomePageAdapter(FragmentManager fm, Context context, List<String> titles) {
        super(fm);
        mTitles = titles;
        mFragments = new Fragment[titles.size()];
    }

    @Override
    public Fragment getItem(int position) {

        if (mFragments[position] == null) {
            switch (position) {
                case 0:
                    mFragments[position] = RecommendFragment.newInstance();
                    break;
                case 1:
                    mFragments[position] = MobileGameFragment.newInstance();
                    break;
                case 2:
                    mFragments[position] = RecreationFragment.newInstance();
                    break;
                case 3:
                    mFragments[position] = OnlineGameFragment.newInstance();
                    break;
                case 4:
                    mFragments[position] = OtherFragment.newInstance();
                    break;
            }
        }

        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
