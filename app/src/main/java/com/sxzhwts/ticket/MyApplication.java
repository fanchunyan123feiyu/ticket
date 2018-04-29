package com.sxzhwts.ticket;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
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
                    .appModule(new AppModule(this))
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
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.black);//全局设置主题颜色
                //return new ClassicsHeader(context).setTimeFormat(new DynamicT("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
                //return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
                return new MaterialHeader(context).setColorSchemeColors(Color.rgb(86,156,204),Color.rgb(231,52,8),Color.rgb(231,141,8),Color.rgb(136,206,32));
            }

        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                layout.setFooterHeight(25);
                layout.setPrimaryColors(R.color.bg_gray);
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });

    }
}
