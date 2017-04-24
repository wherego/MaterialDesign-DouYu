package com.jiezzzo.douyu;

import android.app.Application;

import com.jiezzzo.douyu.common.api.ApiService;
import com.jiezzzo.douyu.common.api.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by oaier on 2017/4/20.
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {
    Application getApplication();
    ApiService getApiService();
}
