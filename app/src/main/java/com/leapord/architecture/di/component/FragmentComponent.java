package com.leapord.architecture.di.component;

import android.app.Activity;

import com.leapord.architecture.di.module.FragmentModule;
import com.leapord.architecture.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

//    void inject(BaseFragment baseFragment);


}
