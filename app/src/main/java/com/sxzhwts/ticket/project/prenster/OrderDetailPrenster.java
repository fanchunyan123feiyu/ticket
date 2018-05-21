package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.bean.response.BusOrderDetailResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.OrderDetailContract;
import com.sxzhwts.ticket.project.views.OrderDetailActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/16 10:52
 */


public class OrderDetailPrenster implements OrderDetailContract.Presenter{
    private ApiService apiService;
    private OrderDetailActivity orderDetailActivity;

    @Inject
    public OrderDetailPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        this.orderDetailActivity = (OrderDetailActivity) baseMvpActivity;

    }

    @Override
    public void getOrderDetailById(String clientToken, String order_id) {
        apiService.getOrderDetailById(clientToken,order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(orderDetailActivity.bind2Lifecycle())
                .subscribe(new Consumer<BusOrderDetailResult>() {
                    @Override
                    public void accept(BusOrderDetailResult orderResult) throws Exception {
                        orderDetailActivity.getBusOrderDetailSucess(orderResult);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        throwable.printStackTrace();
                        Log.e("TAG","根据订单id获取订单详情"+clientToken);
                        orderDetailActivity.hideLoading();
                        if (!SystemUtil.isNetworkConnected()) {
                            orderDetailActivity.showNoNet();
                        } else {
                            orderDetailActivity.showError();
                        }
                    }
                });

    }


    @Override
    public void getOrderDetailByOrderCode(String clientToken, String ordercode) {
        Log.e("TAG","通过ordercode"+clientToken+"----"+ordercode);
        apiService.getOrderDetailByCode(clientToken,ordercode, Constant.resourceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(orderDetailActivity.bind2Lifecycle())
                .subscribe(new Consumer<BusOrderDetailResult>() {
                    @Override
                    public void accept(BusOrderDetailResult orderResult) throws Exception {
                            orderDetailActivity.getBusOrderDetailSucess(orderResult);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","登录错误");
                        orderDetailActivity.hideLoading();
                        if(throwable instanceof JsonSyntaxException){
                            ToastUtils.showToast(orderDetailActivity,"核销码有误,请重新输入！！！");
                            orderDetailActivity.finishedActivity();
                        }else{
                            if (SystemUtil.isNetworkConnected()) {
                                orderDetailActivity.showNoNet();
                            } else {
                                orderDetailActivity.showError();
                            }
                        }

                    }
                });
    }

    @Override
    public void verication(String clientToken, String order_id) {
        apiService.verication(clientToken,order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(orderDetailActivity.bind2Lifecycle())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        orderDetailActivity.verication(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","登录错误");
                        orderDetailActivity.hideLoading();
                        if (!SystemUtil.isNetworkConnected()) {
                            orderDetailActivity.showNoNet();
                        } else {
                            orderDetailActivity.showError();
                        }
                    }
                });

    }
    @Override
    public void sureOutTicket(String clientToken, String order_id) {
        apiService.sureOutTicket(clientToken,order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(orderDetailActivity.bind2Lifecycle())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        orderDetailActivity.sureTicket(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","登录错误");
                        orderDetailActivity.hideLoading();
                        if (SystemUtil.isNetworkConnected()) {
                            orderDetailActivity.showNoNet();
                        } else {
                            orderDetailActivity.showError();
                        }
                    }
                });

    }
}
