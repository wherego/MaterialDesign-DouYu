package com.jiezzzo.douyu.ui.homepage.recreation;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * 娱乐
 * Created by oaier on 2017/4/25.
 */

public class RecreationFragment extends RxBaseLazyFragment {

    public static RecreationFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecreationFragment fragment = new RecreationFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_home_recreation;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
