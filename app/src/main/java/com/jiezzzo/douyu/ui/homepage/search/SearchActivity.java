package com.jiezzzo.douyu.ui.homepage.search;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oaier on 2017/4/24.
 */

public class SearchActivity extends RxBaseActivity {

    @BindView(R.id.search_back)
    ImageButton mSearchBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int setContentView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initToolbar() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.search_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
