package com.leapord.architecture.di.component;

import android.app.Activity;

import com.leapord.architecture.di.module.ActivityModule;
import com.leapord.architecture.di.scope.ActivityScope;
import com.leapord.architecture.ui.activity.MainActivity;
import com.leapord.architecture.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

}
