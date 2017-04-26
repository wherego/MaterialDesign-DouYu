package com.jiezzzo.douyu;

import android.content.Context;

import com.jiezzzo.douyu.common.util.NetUtils;

/**
 * Created by oaier on 2017/4/26.
 */

public final class AppClient {
    private Context mContext;

    public AppClient(Context context) {
        mContext = context;
    }

    public boolean isNetConnected() {
        return NetUtils.isConnected(mContext);
    }

}
