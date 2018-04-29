package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpFragment;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.bean.response.HomeResulst;
import com.sxzhwts.ticket.project.contract.HomeContract;
import com.sxzhwts.ticket.project.views.HomeFragment2;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/16 10:52
 */

public class HomePrenster implements HomeContract.Presenter{
    private ApiService apiService;
    private HomeFragment2 fragment2;

    @Inject
    public HomePrenster(ApiService apiService, BaseMvpFragment baseMvpFragment) {
        this.apiService = apiService;
        this.fragment2 = (HomeFragment2) baseMvpFragment;

    }

/*    @Override
    public void getAllOrder(String access_token, String resourceId) {
        Log.e("TAG","获取订单"+access_token+"-----"+resourceId);
        apiService.getAllOrder(access_token,resourceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment2.bind2Lifecycle())
                .subscribe(new Consumer<OrderResult>() {
                    @Override
                    public void accept(OrderResult orderResult) throws Exception {
                        Log.e("TAG"," 获取订单成功"+orderResult.getData().getSumcount());
                        fragment2.getOrderSucess(orderResult);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG"," 获取订单错误");
                        if (SystemUtil.isNetworkConnected()) {
                            //mainActivity.showNoNet();
                        } else {
                           // mainActivity.showError();
                        }
                    }
                });
    }*/

    @Override
    public void getReadySureOrder(String access_token, String resourceId) {
        fragment2.showLoading();
        apiService.getReadySureOrder(access_token,resourceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment2.bind2Lifecycle())
                .subscribe(new Consumer<HomeResulst>() {
                    @Override
                    public void accept(HomeResulst homeResulst) throws Exception {
                        Log.e("TAG"," 获取订单成功"+homeResulst.getData().getSumcount());
                        fragment2.hideLoading();
                        fragment2.getReadySureOrderSucess(homeResulst);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG"," 获取订单错误");
                        fragment2.hideLoading();
                        if (!SystemUtil.isNetworkConnected()) {
                           fragment2.showNoNet();
                        } else {
                           fragment2.showError();
                        }
                    }
                });
    }
}
