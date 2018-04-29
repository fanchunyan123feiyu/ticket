package com.sxzhwts.ticket.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sxzhwts.ticket.MyApplication;
import com.sxzhwts.ticket.common.utils.DialogUtils;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.di.component.ActivityComponent;
import com.sxzhwts.ticket.di.component.AppComponent;
import com.sxzhwts.ticket.di.component.DaggerActivityComponent;
import com.sxzhwts.ticket.di.module.ActivityModule;
import com.trello.rxlifecycle2.LifecycleTransformer;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：fcy on 2018/4/13 17:13
 */

public abstract class BaseMvpActivity<P extends BaseContract.BasePresenter> extends BaseAcivity implements BaseContract.BaseView{
    @Inject
    protected P mPrenster;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initInject();
        super.onCreate(savedInstanceState);
        unbinder= ButterKnife.bind(this);

    }

    protected abstract void initInject();

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();

    }
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
    //获取AppComponent
    protected AppComponent getAppComponent() {
        return MyApplication.getInstamce().getAppComponent();
    }
    // Activity 与 Presenter 绑定生命周期
    @Override
    public <E> LifecycleTransformer<E> bind2Lifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void showLoading() {
        DialogUtils.showProgressDialog(mContext,"正在加载中...");
    }

    @Override
    public void hideLoading() {
        DialogUtils.disProgressDialog();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError() {
        ToastUtils.showToast(mContext,"连接出错，请点击重试");
    }

    @Override
    public void showNoNet() {
        ToastUtils.showToast(mContext,"网络错误，请检查您的网路是否畅通");
    }

    @Override
    public void connectTime() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder=null;
    }
}
