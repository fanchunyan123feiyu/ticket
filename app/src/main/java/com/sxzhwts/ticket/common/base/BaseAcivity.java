package com.sxzhwts.ticket.common.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.utils.EventUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * 作者：fcy on 2018/4/13 15:23
 * 无MVP的activity基类
 */

public abstract class BaseAcivity extends RxAppCompatActivity {
    // private Unbinder unbinder;
    protected Activity mContext;

    protected RelativeLayout titleLayout;
    protected TextView titleText;
    protected ImageView titleBack;
    private SmartRefreshLayout smartRefreshLayout;
    protected int pageNumb = 1;//页码，供子类使用
    protected boolean isLoadMore;//判断是否上拉加载，供子类使用

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;
        disableLandOrientation();
        if (registerEventBus()) {
            EventUtil.register(this);
        }
        initBaseView();
        ButterKnife.bind(this);
        initBaseLoadData();
        initViewAndEvent();
        initData();
    }

    protected SmartRefreshLayout getSmartRefreshLayout() {
        return smartRefreshLayout;
    }

    private void initBaseLoadData() {
        titleBack.setOnClickListener(view -> {
            finishedActivity();
        });
        smartRefreshLayout.setEnableHeaderTranslationContent(false);
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadData(true);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                loadData(false);
            }
        });
    }

    //加载数据
    protected void loadData(boolean isLoadMore) {
        this.isLoadMore = isLoadMore;
        if (isLoadMore) {
            pageNumb++;
        } else {
            pageNumb = 1;
        }
        Log.e("TAG", "parent loadData");
    }

    ;

    private void initBaseView() {
        FrameLayout mainView = (FrameLayout) findViewById(R.id.fra_base_main);
        titleLayout = (RelativeLayout) findViewById(R.id.titleView);
        titleText = (TextView) findViewById(R.id.titleText);
        titleBack = (ImageView) findViewById(R.id.title_back);
        View childLayoutView = LayoutInflater.from(this).inflate(getChildlayout(), null);
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        smartRefreshLayout.setEnableRefresh(false);//设置默认关闭下拉刷新功能
        smartRefreshLayout.setEnableLoadMore(false);
       // smartRefreshLayout.setEnableHeaderTranslationContent(false);
       // smartRefreshLayout.setEnableLoadmore(false);//默认关闭刷新，需要刷新时子类去实现
       // smartRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);//设置当内容不满一个页面时，是否可以加载更多
       // smartRefreshLayout.setEnableNestedScroll()
       // smartRefreshLayout.setEnableLoadMoreWhenContentNotFull(true);
        mainView.addView(childLayoutView);



    }

    protected abstract int getChildlayout();

    //protected abstract boolean registerEventBus();//是否需要注册EventBus  注册之后才能够接收发送出的事件
    protected abstract void initViewAndEvent();//初始化view和事件

    protected void initData() {
    }

    ;//加载数据

    protected boolean registerEventBus() {
        return false;
    }

    /**
     * 禁止水平旋转
     */
    private void disableLandOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.tr_entry, R.anim.tr_void);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.tr_entry, R.anim.tr_void);
    }

    public void finishedActivity() {
        finish();
        overridePendingTransition(R.anim.tr_void, R.anim.tr_exit);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (registerEventBus()) {
            EventUtil.unregister(this);
        }
        //unbinder.unbind();
    }
}
