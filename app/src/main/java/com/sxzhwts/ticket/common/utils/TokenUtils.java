package com.sxzhwts.ticket.common.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;

import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.api.TokenService;
import com.sxzhwts.ticket.common.http.UrlManger;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.bean.response.TokenResult;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/3.
 * 客户端token工具类
 *
 */

public class TokenUtils {
    String client_name = "ticket_admin_app"; //客户端名称
    String client_secret = "ticket_admin_app_password";//客户端密钥

    private Context context;
    public TokenUtils(Context context){
        this.context=context;
    }
    public  void getTokenFromServer(final tokenSuccessListenter tokenSuccessListenter) {

        byte[] str = (client_name + ":" + client_secret).getBytes();
        String auth = Base64.encodeToString(str, 0).trim();

        TokenService tokenServiceApi = RetrofitUtils.getRetrofitInstance(UrlManger.server_api_url).create(TokenService.class);
        tokenServiceApi.getToken("Basic "+auth, "client_credentials")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TokenResult>() {
                    @Override
                    public void accept(@NonNull TokenResult tokenResult) throws Exception {
                        Log.e("TAG",tokenResult.getAccess_token()+"获取到token");
                        Constant.clientToken=tokenResult.getAccess_token();
                        Constant.clientTokenTime = System.currentTimeMillis() / 1000;
                        tokenSuccessListenter.tokenSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","Throwable");
                        tokenSuccessListenter.tokenFial();
                        Intent intent = new Intent();
                        intent.setClassName("com.sxzhwts.ticket", "MainActivity");
                        if(intent.resolveActivity(context.getPackageManager()) == null) {
                            Log.e("TAG","2不存在开启");
                            ((Activity)context).startActivity(new Intent(context,MainActivity.class));
                            // 说明系统中不存在这个activity
                        }
                    }
                });
    }
public  interface tokenSuccessListenter{
    public  void tokenSuccess();
    public  void tokenFial();

}
}
