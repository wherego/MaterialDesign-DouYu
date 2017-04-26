package com.jiezzzo.douyu.ui.homepage.recommend;

import android.os.Bundle;

import com.jiezzzo.douyu.AppComponent;
import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;
import com.jiezzzo.douyu.ui.homepage.DaggerHomePageComponent;
import com.jiezzzo.douyu.ui.homepage.HomePageModule;

import javax.inject.Inject;

/**
 * 推荐
 * Created by oaier on 2017/4/25.
 */

public class RecommendFragment extends RxBaseLazyFragment implements RecommendContract.View {

    @Inject RecommendPresenter mPresenter;

    public static RecommendFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentAppComponent(AppComponent appComponent) {
        DaggerHomePageComponent.builder().appComponent(appComponent).homePageModule(new HomePageModule(this)).build().inject(this);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mPresenter.start();
    }

    @Override
    public void requestNetworkFailure() {

    }
}
