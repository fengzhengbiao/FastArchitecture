package com.leapord.architecture.di.component;


import com.leapord.architecture.app.App;
import com.leapord.architecture.di.module.AppModule;
import com.leapord.architecture.di.module.HttpModule;
import com.leapord.architecture.model.DataManager;
import com.leapord.architecture.model.http.RetrofitHelper;
import com.leapord.architecture.model.prefs.PrefesHelperImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    PrefesHelperImpl preferencesHelper(); //提供sp帮助类
}
