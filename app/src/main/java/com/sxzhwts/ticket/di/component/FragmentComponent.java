package com.sxzhwts.ticket.di.component;

import com.sxzhwts.ticket.di.module.FragmentModule;
import com.sxzhwts.ticket.di.scope.FragmentScope;
import com.sxzhwts.ticket.project.views.HomeFragment2;

import dagger.Component;

;

/**
 * Created by zyl on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(HomeFragment2 homeFragment);

}
