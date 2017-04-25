package com.jiezzzo.douyu.ui.live;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * Created by oaier on 2017/4/25.
 */

public class LiveFragment extends RxBaseLazyFragment {

    public static LiveFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
