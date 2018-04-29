package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.common.utils.TimesUtils;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.OrderListContract;
import com.sxzhwts.ticket.project.views.AllOrderActivity;
import com.sxzhwts.ticket.project.views.ReadySureActivity;

import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/16 10:52
 */

public class OrderListPrenster implements OrderListContract.Presenter{
    private ApiService apiService;
    private AllOrderActivity allOrderActivity;
    private ReadySureActivity readySureActivity;

    @Inject
    public OrderListPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        if(baseMvpActivity instanceof AllOrderActivity){
            this.allOrderActivity = (AllOrderActivity) baseMvpActivity;
        }
        if(baseMvpActivity instanceof ReadySureActivity){
            this.readySureActivity = (ReadySureActivity) baseMvpActivity;
        }


    }

    @Override
    public void getOrderList(String clientToken, String resourceId, String state, String page) {
        Log.e("TAG",clientToken+"  "+resourceId+"  "+state+" "+page+"page");
        String endTime=TimesUtils.parseYMd(TimesUtils.dayOperation(new Date(),1));
       /* begintime: 2018-02-17
        endtime: 2018-04-20
        2018-04-20  2018-02-20*/
        Date month2=TimesUtils.monthOperation(TimesUtils.dayOperation(new Date(),1),-2);//先减去2个月
        String beginTime=TimesUtils.parseYMd(TimesUtils.dayOperation(month2,-3));
        Log.e("TAG",beginTime+endTime);

        Observable<OrderResult> orderResultObservable = apiService.getAllOrder(clientToken, resourceId, state, page, beginTime, endTime, "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        if(allOrderActivity!=null){
            orderResultObservable.compose(allOrderActivity.bind2Lifecycle())
                    .subscribe(new Consumer<OrderResult>() {
                        @Override
                        public void accept(OrderResult orderResult) throws Exception {
                            Log.e("TAG",clientToken+"  "+resourceId+"  "+state+" "+page);
                            Log.e("TAG",orderResult.getData().getOrderlist().getData().size()+"数据1 个数");
                            allOrderActivity.hideLoading();
                            allOrderActivity.getOrderListSucess(orderResult);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e("TAG","登录错误");
                            allOrderActivity.hideLoading();
                            if (!SystemUtil.isNetworkConnected()) {
                                allOrderActivity.showNoNet();
                            } else {
                                allOrderActivity.showError();
                            }
                        }
                    });
        }
            if(readySureActivity!=null){
                orderResultObservable.compose(readySureActivity.bind2Lifecycle())
                        .subscribe(new Consumer<OrderResult>() {
                            @Override
                            public void accept(OrderResult orderResult) throws Exception {
                                Log.e("TAG",clientToken+"  "+resourceId+"  "+state+" "+page);
                                Log.e("TAG",orderResult.getData().getOrderlist().getData().size()+"数据2 个数");
                                readySureActivity.hideLoading();
                                readySureActivity.getOrderListSucess(orderResult);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                                Log.e("TAG","登录错误");
                                readySureActivity.hideLoading();
                                if (SystemUtil.isNetworkConnected()) {
                                    readySureActivity.showNoNet();
                                } else {
                                    readySureActivity.showError();
                                }
                            }
                        });
            }


    }
    @Override
    public void verication(String clientToken, String order_id) {
        apiService.verication(clientToken,order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(allOrderActivity.bind2Lifecycle())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        allOrderActivity.verication(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG","登录错误");
                        allOrderActivity.hideLoading();
                        if (SystemUtil.isNetworkConnected()) {
                            allOrderActivity.showNoNet();
                        } else {
                            allOrderActivity.showError();
                        }
                    }
                });
    }
    @Override
    public void orderfirmyes(String clientToken, String order_id) {
        Observable<Result> resultObservable = apiService.orderfirmyes(clientToken, order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        if(allOrderActivity!=null){
            resultObservable .compose(allOrderActivity.bind2Lifecycle())
                    .subscribe(new Consumer<Result>() {
                        @Override
                        public void accept(Result result) throws Exception {
                            allOrderActivity.sure(result);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e("TAG","登录错误");
                            allOrderActivity.hideLoading();
                            if (SystemUtil.isNetworkConnected()) {
                                allOrderActivity.showNoNet();
                            } else {
                                allOrderActivity.showError();
                            }
                        }
                    });
        }
        if(readySureActivity!=null){
            resultObservable .compose(readySureActivity.bind2Lifecycle())
                    .subscribe(new Consumer<Result>() {
                        @Override
                        public void accept(Result result) throws Exception {
                            readySureActivity.sure(result);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e("TAG","登录错误");
                            readySureActivity.hideLoading();
                            if (SystemUtil.isNetworkConnected()) {
                                readySureActivity.showNoNet();
                            } else {
                                readySureActivity.showError();
                            }
                        }
                    });
        }

    }
}
