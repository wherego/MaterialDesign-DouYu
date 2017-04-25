package com.jiezzzo.douyu.ui.homepage.onlinegame;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * 游戏
 * Created by oaier on 2017/4/25.
 */

public class OnlineGameFragment extends RxBaseLazyFragment {

    public static OnlineGameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OnlineGameFragment fragment = new OnlineGameFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_home_onlinegame;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
