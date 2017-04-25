package com.jiezzzo.douyu.ui.user;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * Created by oaier on 2017/4/25.
 */

public class UserFragment extends RxBaseLazyFragment {

    public static UserFragment newInstance() {
        
        Bundle args = new Bundle();
        
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
