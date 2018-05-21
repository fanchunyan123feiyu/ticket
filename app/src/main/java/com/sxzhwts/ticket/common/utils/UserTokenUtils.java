package com.sxzhwts.ticket.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.http.UrlManger;
import com.sxzhwts.ticket.project.bean.response.LoginResult;
import com.sxzhwts.ticket.project.views.LoginActivity;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/5/18 09:26
 */

public class UserTokenUtils {
   private Context mContext;
    public UserTokenUtils(Context context) {
        this.mContext=context;
    }

    public void   getUserToken(UserTokenSuccessListenter userTokenSuccessListenter){
        new TokenUtils(mContext).getTokenFromServer(new TokenUtils.tokenSuccessListenter() {
            @Override
            public void tokenSuccess() {
                SharedPresUtils loginPres = SharedPresUtils.getSharedPresUtils(mContext);
                Map map = loginPres.loadUserInfo();
                String username = (String) map.get("username");
                String userpwd = (String) map.get("userpwd");
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(userpwd)) {
                    ( (Activity)mContext).startActivity(new Intent(mContext, LoginActivity.class));
                    ( (Activity)mContext).finish();
                } else {
                    Log.e("TAG", "enterLogin2" + username + userpwd);
                    RetrofitUtils.getRetrofitInstance(UrlManger.base_url).create(ApiService.class).
                            login(Constant.clientToken, username, userpwd)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<LoginResult>() {
                                @Override
                                public void accept(LoginResult loginResult) throws Exception {
                                    Log.e("TAG",loginResult.toString()+"登录成功");
                                   Constant.userToken=loginResult.getData().getAccess_token();
                                    userTokenSuccessListenter.tokenSuccess();
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                    Log.e("TAG","登录错误");
                                    if (SystemUtil.isNetworkConnected()) {
                                       ToastUtils.showToast(mContext,"网络错误，请检查您的网络是否连接");
                                    }
                                }
                            });
                }
            }
            @Override
            public void tokenFial() {
                Log.e("TAG","login1  tokenFial");
                ToastUtils.showToast(mContext, "网络错误，请检查您的网络");
            }
        });
    }
    public  interface UserTokenSuccessListenter{
        public  void tokenSuccess();

    }
}
