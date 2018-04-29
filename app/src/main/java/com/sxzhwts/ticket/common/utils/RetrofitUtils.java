package com.sxzhwts.ticket.common.utils;

import android.util.Base64;

import com.sxzhwts.ticket.common.Constant;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fcy on 2017/12/6.
 */

public class RetrofitUtils {
    private static Retrofit retrofit=null;
    private  static OkHttpClient client = new OkHttpClient.Builder()
           .addInterceptor(getBuidNetworkInterceptor())
            .cache(getCacheDirectory())
            .build();

    public static Retrofit getRetrofitInstance(String baseUrl){

                       retrofit= new Retrofit.Builder()
                               //.client(client)
                               .baseUrl(baseUrl)
                               .addConverterFactory(GsonConverterFactory.create())//gson
                               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RXjava
                               .build();



        return retrofit;
    }

    private static Cache getCacheDirectory() {
        File cacheFile=new File(Constant.cacheHttp);
        Cache cacheSize=new Cache(cacheFile,1024*1024*20);
        return cacheSize;
    }
private  static Interceptor getHeaderInterceptor (){//通过拦截方式添加header
    return new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //客户端名称
            String client_name = "android_app";
            //客户端密钥
            String client_secret = "android_app_password";
            byte[] str=(client_name+":"+client_secret).getBytes();
            String auth= Base64.encodeToString(str,0).trim();
            Request original=chain.request();
            Request request = original.newBuilder()
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("authorization","Basic "+ auth)
                     .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        }
    };
}
    //创建缓存拦截器
    private static Interceptor getBuidNetworkInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //无网络时,重缓存中读取
                if (!SystemUtil.isNetworkConnected()) {
                    request=request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }
                //获取响应体，在线时缓存5分钟，离线时缓存4周
                Response response=chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxTime=300;
                    response.newBuilder().header("Cache-Control", "public, max-age=" + maxTime)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                }else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
    }
}
