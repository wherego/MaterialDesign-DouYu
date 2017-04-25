package com.jiezzzo.douyu.ui.homepage.other;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * 趣玩
 * Created by oaier on 2017/4/25.
 */

public class OtherFragment extends RxBaseLazyFragment {

    public static OtherFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OtherFragment fragment = new OtherFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_home_other;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
