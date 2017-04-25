package com.jiezzzo.douyu.ui.homepage.mobilegame;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * 手游
 * Created by oaier on 2017/4/25.
 */

public class MobileGameFragment extends RxBaseLazyFragment {

    public static MobileGameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MobileGameFragment fragment = new MobileGameFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_home_mobilegame;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
