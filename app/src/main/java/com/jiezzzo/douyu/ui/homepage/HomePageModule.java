package com.jiezzzo.douyu.ui.homepage;

import com.jiezzzo.douyu.AppClient;
import com.jiezzzo.douyu.common.api.ApiService;
import com.jiezzzo.douyu.ui.FragmentScope;
import com.jiezzzo.douyu.ui.homepage.recommend.RecommendContract;
import com.jiezzzo.douyu.ui.homepage.recommend.RecommendPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oaier on 2017/4/26.
 */
@Module
public class HomePageModule {

    private RecommendContract.View recommendView;

    public HomePageModule() {
    }

    public HomePageModule(RecommendContract.View recommendView) {
        this.recommendView = recommendView;
    }

    @Provides @FragmentScope RecommendContract.View provideRecommendView() {
        return recommendView;
    }

    @Provides @FragmentScope RecommendPresenter provideRecommendPresenter(ApiService apiService, AppClient client) {
        return new RecommendPresenter(apiService, recommendView, client);
    }

}
