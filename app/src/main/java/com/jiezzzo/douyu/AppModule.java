package com.jiezzzo.douyu;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oaier on 2017/4/20.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }
    @Provides @Singleton Application provideApplication() {
        return mApplication;
    }
}
