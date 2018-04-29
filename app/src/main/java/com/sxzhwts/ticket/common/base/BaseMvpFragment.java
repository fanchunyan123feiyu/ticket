package com.sxzhwts.ticket.common.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxzhwts.ticket.MyApplication;
import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.utils.EventUtil;
import com.sxzhwts.ticket.di.component.DaggerFragmentComponent;
import com.sxzhwts.ticket.di.component.FragmentComponent;
import com.sxzhwts.ticket.di.module.FragmentModule;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zyl on 2016/8/2.
 * MVP Fragment基类
 */
public abstract class BaseMvpFragment<T extends BaseContract.BasePresenter> extends RxFragment
        implements BaseContract.BaseView {

    @Inject
    protected T mPresenter;


    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    private View mRootView;
    private boolean mIsMulti = false;
    protected boolean needShowLoading;
    private Dialog loadingDialog;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getInstamce().getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), null);
            mUnBinder = ButterKnife.bind(this, mRootView);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        //loadingDialog = LoadingDialogHelper.getLoadingDialog(mContext);

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInject();
        initViewAndEvent();
        if (registerEvent()) EventUtil.register(this);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint() && mRootView != null && !mIsMulti) {
            // mIsMulti = true;
            initData(true);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && isVisible() && mRootView != null && !mIsMulti) {
            //mIsMulti = true;
            initData(true);
        } else {
            super.setUserVisibleHint(isVisibleToUser);
        }
    }

    public void showLoadingDialog(String str) {
        if (loadingDialog != null) {
            TextView tv = (TextView) loadingDialog.findViewById(R.id.tv_load_dialog);
            tv.setText(str);
            loadingDialog.show();
        }
    }

    @Override
    public void connectTime() {

    }

    public void showLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    public void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }


    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showNoNet() {
        //ToastUtils.showToast("网络异常");
        hideLoadingDialog();

    }

    // Activity 与 Presenter 绑定生命周期
    @Override
    public <E> LifecycleTransformer<E> bind2Lifecycle() {
        return this.bindToLifecycle();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // 解绑butterKnife
        mUnBinder.unbind();
        if (registerEvent()) {
            EventUtil.unregister(this);
        }
    }

    /*
     * 是否注册EventBus
     */
    protected abstract boolean registerEvent();

    /*
    * 初始化dagger2
    */
    protected abstract void initInject();

    /*
    * 初始化布局
    */
    protected abstract int getLayoutId();

    /*
    * 初始化view 和事件
    */
    protected abstract void initViewAndEvent();

    /*
    * 获取数据
    */
    protected  void initData(boolean needShowLoading){};
}
