package com.sxzhwts.ticket.common.http;

import com.sxzhwts.ticket.project.convert.ResponseConverterFactory;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 作者：fcy on 2018/4/14 13:46
 */

public class RetrofitHelper {
    private OkHttpClient client;
   // private ApiService apiService;

    @Inject
    public RetrofitHelper(OkHttpClient client) {
        this.client = client;
    }

    public   <T> T getApiService(String baseUrl, Class<T> clz) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(ResponseConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                //.addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build();
        return retrofit.create(clz);
    }

}
