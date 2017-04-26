package com.jiezzzo.douyu.common.api;

import com.jiezzzo.douyu.ui.homepage.recommend.BannerDetailBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by oaier on 2017/4/20.
 */

public interface ApiService {
    @POST("api/v1/slide/6")
    Observable<BannerDetailBean> getBannerDetailInfo(@Query("version") String version, @Query("client_sys") String client_sys);
}
