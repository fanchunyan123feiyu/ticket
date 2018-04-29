package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.ReasonSubmitContract;
import com.sxzhwts.ticket.project.views.FialResonSubmitActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/14 14:17
 */

public class ReasonSubmitPrenster implements ReasonSubmitContract.Presenter {
    private ApiService apiService;
    private FialResonSubmitActivity fialResonSubmitActivity;

    @Inject
    public ReasonSubmitPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
       this.fialResonSubmitActivity=(FialResonSubmitActivity) baseMvpActivity;
    }


    @Override
    public void submit(String access_token, String order_id, String remark) {
        apiService.submitReason(access_token,order_id,remark)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fialResonSubmitActivity.bind2Lifecycle())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        Log.e("TAG","修改密码成功");
                        fialResonSubmitActivity.submitSucess(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","修改密码错误");
                        fialResonSubmitActivity.hideLoading();
                        if (SystemUtil.isNetworkConnected()) {
                            fialResonSubmitActivity.showNoNet();
                        } else {
                            fialResonSubmitActivity.showError();
                        }
                    }
                });
    }
}
