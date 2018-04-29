package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.bean.response.LoginResult;
import com.sxzhwts.ticket.project.contract.LoginContract;
import com.sxzhwts.ticket.project.views.LoginActivity;
import com.sxzhwts.ticket.project.views.SplashActivity;

import java.net.SocketTimeoutException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/14 14:17
 */

public class LoginPrenster implements LoginContract.Presenter {
    private ApiService apiService;
    private SplashActivity splashActivity=null;
    private LoginActivity loginActivity=null;

    @Inject
    public LoginPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        if(baseMvpActivity instanceof LoginActivity){
            this.loginActivity = (LoginActivity) baseMvpActivity;
        }else if(baseMvpActivity instanceof SplashActivity){
            this.splashActivity = (SplashActivity) baseMvpActivity;
        }
    }


    @Override
    public void login(String account, String password, String clientToken) {
        if(loginActivity!=null){
            apiService.login(clientToken, account, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(loginActivity.bind2Lifecycle())
                    .subscribe(new Consumer<LoginResult>() {
                        @Override
                        public void accept(LoginResult loginResult) throws Exception {
                            Log.e("TAG",loginResult.toString()+"登录成功");
                            if (loginResult.code == 1) {
                                loginActivity.loginSucess(loginResult);
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e("TAG","登录错误");

                            if (SystemUtil.isNetworkConnected()) {
                                loginActivity.showNoNet();
                            } else  if(throwable instanceof SocketTimeoutException){
                                loginActivity.connectTime();
                            }else {
                                loginActivity.showError();
                            }
                        }
                    });
        }else if( splashActivity!=null){
            splashActivity.showLoading();
            apiService.login(clientToken, account, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(splashActivity.bind2Lifecycle())
                    .subscribe(new Consumer<LoginResult>() {
                        @Override
                        public void accept(LoginResult loginResult) throws Exception {
                            splashActivity.hideLoading();
                            Log.e("TAG",loginResult.toString()+"登录成功");
                            if (loginResult.code == 1) {
                                splashActivity.loginSucess(loginResult);
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e("TAG","登录错误");
                            splashActivity.hideLoading();
                            if (SystemUtil.isNetworkConnected()) {
                                splashActivity.showNoNet();
                            } else {
                                splashActivity.showError();
                            }
                        }
                    });
        }

    }
}
