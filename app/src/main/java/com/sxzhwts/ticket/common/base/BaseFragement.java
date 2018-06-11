package com.sxzhwts.ticket.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.sxzhwts.ticket.R;

import butterknife.ButterKnife;

/**
 * Created by bibinet on 2017-11-6.
 */

public abstract class BaseFragement extends LazyFragement {
    private SmartRefreshLayout smartRefreshLayout;
    public RelativeLayout titleLayout;
    public TextView title_textView;
    public ImageView title_back;



    @Nullable
    @Override//初始化view，将view初始化好以后传递给onviewCreated方法
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_base, container, false);
        FrameLayout mainLayout = (FrameLayout) view.findViewById(R.id.fra_base_main);
        titleLayout = (RelativeLayout) view.findViewById(R.id.titleView);
        title_textView=(TextView)view.findViewById(R.id.title);
        title_back=(ImageView)view.findViewById(R.id.title_back);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        View fragememtHomeView = LayoutInflater.from(getActivity()).inflate(getFragementHomeLayout(), null);
        mainLayout.addView(fragememtHomeView);
        initBaseView();
        return view;
    }
  /*  protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getInstamce().getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }*/
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        isInitView=true;
       // initInject();
        initView();
       // if (registerEvent()) EventUtil.register(this);
        lazyLoadData();//进行懒加载
    }
    /*
        * 是否注册EventBus
        */
   // protected abstract boolean registerEvent();

    /*
    * 初始化dagger2
    */
  //  protected abstract void initInject();

    private void initBaseView() {
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableAutoLoadMore(false);//设置自动上拉加载为不可用
        smartRefreshLayout.setEnableLoadMore(false);//设置上拉加载
        smartRefreshLayout.setEnableHeaderTranslationContent(false);
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadMoreData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshData();
            }
        });
    }

    protected  void refreshData(){};

    protected  void loadMoreData(){};
    // Activity 与 Presenter 绑定生命周期
    /*public <E> LifecycleTransformer<E> bind2Lifecycle() {
        return this.bindToLifecycle();
    }
*/
    protected abstract int getFragementHomeLayout();

    protected SmartRefreshLayout getSmartRefreshLayout() {
        return smartRefreshLayout;

    }

    protected abstract void initView();


}
