package com.sxzhwts.ticket.di.module;

import android.content.Context;

import com.sxzhwts.ticket.MyApplication;
import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.http.RetrofitHelper;
import com.sxzhwts.ticket.common.http.UrlManger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：fcy on 2018/4/14 11:51
 */
@Module
public class AppModule {
    private MyApplication application;
    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return application;
    }


    @Provides
    @Singleton
    ApiService provideApiService(RetrofitHelper retrofitHelper) {
        return retrofitHelper.getApiService(UrlManger.base_url,ApiService.class);
    }

/*    @Provides
    @Singleton
    KyApiService provideKyApiService(RetrofitHelper retrofitHelper) {
        return retrofitHelper.getKyApiService();
    }*/

  /*  @Provides
    @Singleton
    @NormlThread
    ThreadPoolProxy provideNormalThreadPoolProxy() {
        return ThreadManager.getNormalPool();
    }*/

 /*   @Provides
    @DownloadThread
    @Singleton
    ThreadPoolProxy provideDownloadThreadPoolProxy() {
        return ThreadManager.getDownloadPool();
    }*/
}
