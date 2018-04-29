package com.sxzhwts.ticket.di.module;


import com.sxzhwts.ticket.common.base.BaseMvpFragment;
import com.sxzhwts.ticket.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {


    private BaseMvpFragment fragment;

    public FragmentModule(BaseMvpFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public BaseMvpFragment provideFragment() {
        return fragment;
    }
}
