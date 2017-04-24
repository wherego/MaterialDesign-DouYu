package com.jiezzzo.douyu.common.api;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jiezzzo.douyu.common.Constant.BASE_URL;
import static com.jiezzzo.douyu.common.Constant.CACHE_SIZE;
import static com.jiezzzo.douyu.common.Constant.CONNECT_TIME_OUT;
import static com.jiezzzo.douyu.common.Constant.READ_TIME_OUT;

/**
 * Created by oaier on 2017/4/20.
 */
@Module
public class ApiServiceModule {
    /**
     *
     * @param application 由Dagger2 寻找Application 进行注入.
     * @return OkHttp的Cache对象.
     */
    @Provides
    @Singleton
    Cache provideCache(final Application application) {
        return new Cache(application.getCacheDir(), CACHE_SIZE);
    }

    /**
     *
     * @param cache 由Dagger2 寻找Cache对象进行注入.
     * @return OKHttpClient 对象.
     */
    @Provides @Singleton
    OkHttpClient provideOkHttpClient(final Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .cache(cache)
                .build();
        return okHttpClient;
    }

    /**
     *
     * @param client 由Dagger2 寻找OKHttpClient对象进行注入.
     * @return ApiSerVice.
     */
    @Provides @Singleton ApiService provideApiService(final OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiService.class);
    }
}
