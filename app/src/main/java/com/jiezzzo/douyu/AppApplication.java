package com.jiezzzo.douyu;

import android.app.Application;
import android.content.Context;

import com.jiezzzo.douyu.common.api.ApiServiceModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by oaier on 2017/4/20.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        mAppComponent = DaggerAppComponent.builder().apiServiceModule(new ApiServiceModule()).appModule(new AppModule(this)).build();
    }

    public static AppApplication get(Context context) {
        return (AppApplication)context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
