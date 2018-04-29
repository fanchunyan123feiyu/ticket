package com.sxzhwts.ticket.di.component;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.di.module.AppModule;
import com.sxzhwts.ticket.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：fcy on 2018/4/14 11:50
 */
@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {
    ApiService getApiService();
}
