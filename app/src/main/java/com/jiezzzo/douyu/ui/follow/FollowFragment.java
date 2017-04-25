package com.jiezzzo.douyu.ui.follow;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * Created by oaier on 2017/4/25.
 */

public class FollowFragment extends RxBaseLazyFragment {

    public static FollowFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FollowFragment fragment = new FollowFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
