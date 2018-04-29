package com.sxzhwts.ticket.di.module;

import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：fcy on 2018/4/14 14:08
 */
@Module
public class ActivityModule {
    private BaseMvpActivity baseMvpActivity;

    public ActivityModule(BaseMvpActivity baseMvpActivity) {
        this.baseMvpActivity = baseMvpActivity;
    }
    @Provides
    @ActivityScope
    public BaseMvpActivity provideActivity(){
        return  baseMvpActivity;
    }
}
