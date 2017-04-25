package com.jiezzzo.douyu.ui.video;

import android.os.Bundle;

import com.jiezzzo.douyu.R;
import com.jiezzzo.douyu.common.base.RxBaseLazyFragment;

/**
 * Created by oaier on 2017/4/25.
 */

public class VideoFragment extends RxBaseLazyFragment {

    public static VideoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int setContentView() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
