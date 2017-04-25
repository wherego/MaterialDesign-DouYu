package com.jiezzzo.douyu.ui.homepage;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;
import com.jiezzzo.douyu.common.widget.NoScrollViewPager;
import com.jiezzzo.douyu.ui.MainActivity;
import com.jiezzzo.douyu.ui.homepage.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by oaier on 2017/4/24.
 */

public class HomePageFragment extends RxBaseLazyFragment {

    @BindView(R.id.logo_btn)
    ImageButton mLogoBtn;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;

    private MainActivity mainActivity;

    public static HomePageFragment newInstance() {

        Bundle args = new Bundle();

        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void firstInit() {
        mainActivity = (MainActivity) getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initToolbar();
        initViewPager();
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("手游");
        titles.add("娱乐");
        titles.add("游戏");
        titles.add("趣玩");
        HomePageAdapter adapter = new HomePageAdapter(getChildFragmentManager(), mainActivity,titles);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

    private void initToolbar() {
        mToolbar.setTitle("");
        mainActivity.setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.logo_btn)
    public void onViewClicked() {
        mainActivity.openDrawer();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_search:
                View searchMenuView = mToolbar.findViewById(R.id.home_search);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(mainActivity, searchMenuView,
                        getString(R.string.transition_search_back)).toBundle();
                startActivityForResult(new Intent(mainActivity, SearchActivity.class), 0, options);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
