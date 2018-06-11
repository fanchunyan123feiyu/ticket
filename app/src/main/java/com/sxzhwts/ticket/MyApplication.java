package com.sxzhwts.ticket;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatDelegate;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.sxzhwts.ticket.di.component.AppComponent;
import com.sxzhwts.ticket.di.component.DaggerAppComponent;
import com.sxzhwts.ticket.di.module.AppModule;
import com.sxzhwts.ticket.di.module.RetrofitModule;

import cn.jpush.android.api.JPushInterface;

/**
 * 作者：fcy on 2018/4/14 12:24
 */

public class MyApplication extends Application {
    private  static MyApplication mAppliactionContext;
    private AppComponent appComponent;
    private Typeface iconTypeFace;

    public static  MyApplication getInstamce(){
        return mAppliactionContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppliactionContext=this;
        if(appComponent==null){
            appComponent= DaggerAppComponent
                    .builder()
                    .appModule(new AppModule())
                    .retrofitModule(new RetrofitModule(this))
                    .build();
        }
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        iconTypeFace = Typeface.createFromAsset(getAssets(),"fonts/iconfont.ttf");
    }
    public Typeface getIconTypeFace() {
        return iconTypeFace;
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
    static {//static 代码段可以防止内存泄露
        //设置全局的Header构建器
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);//启用矢量图兼容
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.black);//全局设置主题颜色
                ClassicsHeader header= new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.FixedBehind);//指定为经典Header，默认是 贝塞尔雷达Header
                header.setAccentColorId(android.R.color.black);
                //header.setPrimaryColorId(R.color.colorAccent);
                return header;//指定为经典Header，默认是 贝塞尔雷达Header
               //return new MaterialHeader(context).setColorSchemeColors(Color.rgb(86,156,204),Color.rgb(231,52,8),Color.rgb(231,141,8),Color.rgb(136,206,32));
            }

        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                layout.setEnableLoadMoreWhenContentNotFull(true);//内容不满一页时候启用加载更多
                ClassicsFooter footer = new ClassicsFooter(context);
                footer.setBackgroundResource(android.R.color.white);
                footer.setSpinnerStyle(SpinnerStyle.Scale);//设置为拉伸模式
                return footer;//指定为经典Footer，默认是 BallPulseFooter
               /* layout.setFooterHeight(25);
                layout.setPrimaryColors(mAppliactionContext.getResources().getColor(R.color.bg_gray));
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);*/
            }
        });

    }
}
