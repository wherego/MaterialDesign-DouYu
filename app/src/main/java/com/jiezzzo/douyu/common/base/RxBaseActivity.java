package com.jiezzzo.douyu.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.jiezzzo.douyu.AppApplication;
import com.jiezzzo.douyu.AppComponent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by oaier on 2017/4/24.
 */

public abstract class RxBaseActivity extends RxAppCompatActivity {
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(setContentView());
        bind = ButterKnife.bind(this);
        setupActivityComponent(AppApplication.get(this).getAppComponent());
        initToolbar();
        if (savedInstanceState == null) {
            firstInit();
        }
        initViews(savedInstanceState);
    }

    @LayoutRes
    protected abstract  int setContentView();
    protected abstract  void initViews(Bundle savedInstanceState);

    protected void setupActivityComponent(AppComponent appComponent) {}
    protected void initToolbar(){}
    protected void firstInit(){}
    protected void loadData(){}
    protected void showProgressBar(){}
    protected void hideProgressBar(){}
    protected void initRecyclerView(){}
    protected void initRefreshLayout(){}
    protected void refreshFinish(){}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
