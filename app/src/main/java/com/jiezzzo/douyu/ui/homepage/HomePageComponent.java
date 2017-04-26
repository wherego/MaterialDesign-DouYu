package com.jiezzzo.douyu.ui.homepage;

import com.jiezzzo.douyu.AppComponent;
import com.jiezzzo.douyu.ui.FragmentScope;
import com.jiezzzo.douyu.ui.homepage.recommend.RecommendFragment;

import dagger.Component;

/**
 * Created by oaier on 2017/4/26.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = HomePageModule.class)
public interface HomePageComponent {
    void inject(RecommendFragment recommendFragment);
}
