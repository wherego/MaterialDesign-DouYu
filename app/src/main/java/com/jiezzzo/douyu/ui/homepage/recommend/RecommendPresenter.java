package com.jiezzzo.douyu.ui.homepage.recommend;

import android.util.Log;

import com.jiezzzo.douyu.AppClient;
import com.jiezzzo.douyu.common.api.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by oaier on 2017/4/26.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private ApiService mApiService;
    private RecommendContract.View mView;
    private AppClient mAppClient;

    public RecommendPresenter(ApiService apiService, RecommendContract.View view, AppClient appClient) {
        mApiService = apiService;
        mView = view;
        mAppClient = appClient;
    }

    @Override
    public void start() {
        if (mAppClient.isNetConnected()) {
            mApiService.getBannerDetailInfo("0", "android")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<BannerDetailBean>() {
                        @Override
                        public void accept(@NonNull BannerDetailBean bannerDetailBean) throws Exception {
                            Log.i("TAG", "URL:"+bannerDetailBean.getData().get(0).getPic_url());
                        }
                    });
        }
    }
}
