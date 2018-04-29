package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.ChangePwdContract;
import com.sxzhwts.ticket.project.views.ChangePwdActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/14 14:17
 */

public class ChangePwdPrenster implements ChangePwdContract.Presenter {
    private ApiService apiService;
    private ChangePwdActivity changePwdActivity;

    @Inject
    public ChangePwdPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        this.changePwdActivity=(ChangePwdActivity) baseMvpActivity;
    }


    @Override
    public void changePwd(String admin_access_token, String old_password, String new_password) {
        apiService.changePwd(admin_access_token,old_password,new_password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(changePwdActivity.bind2Lifecycle())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        Log.e("TAG","修改密码成功");
                        changePwdActivity.changeSucess(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","修改密码错误");
                        changePwdActivity.hideLoading();
                        if (SystemUtil.isNetworkConnected()) {
                            changePwdActivity.showNoNet();
                        } else {
                            changePwdActivity.showError();
                        }
                    }
                });
    }
}
