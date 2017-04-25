package com.jiezzzo.douyu.ui.homepage.recommend;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * 推荐
 * Created by oaier on 2017/4/25.
 */

public class RecommendFragment extends RxBaseLazyFragment {

    public static RecommendFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
