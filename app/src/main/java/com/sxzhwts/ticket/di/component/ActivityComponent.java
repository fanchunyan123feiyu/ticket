package com.sxzhwts.ticket.di.component;

import com.sxzhwts.ticket.di.module.ActivityModule;
import com.sxzhwts.ticket.di.scope.ActivityScope;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.views.AllOrderActivity;
import com.sxzhwts.ticket.project.views.ChangePwdActivity;
import com.sxzhwts.ticket.project.views.FialResonSubmitActivity;
import com.sxzhwts.ticket.project.views.LoginActivity;
import com.sxzhwts.ticket.project.views.OrderDetailActivity;
import com.sxzhwts.ticket.project.views.ReadySureActivity;
import com.sxzhwts.ticket.project.views.SelectSceneryActivity;
import com.sxzhwts.ticket.project.views.SplashActivity;

import dagger.Component;

/**
 * 作者：fcy on 2018/4/14 14:07
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void  inject(LoginActivity activity);
    void  inject(SplashActivity activity);
    void  inject(SelectSceneryActivity activity);
    void  inject(MainActivity activity);
    void  inject(AllOrderActivity activity);
    void  inject(OrderDetailActivity activity);
    void  inject(ChangePwdActivity activity);
    void  inject(FialResonSubmitActivity activity);
    void  inject(ReadySureActivity activity);
}
