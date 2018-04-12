package com.leapord.architecture.di.module;


import com.leapord.architecture.app.App;
import com.leapord.architecture.model.DataManager;
import com.leapord.architecture.model.http.HttpHelper;
import com.leapord.architecture.model.http.RetrofitHelper;
import com.leapord.architecture.model.prefs.PreferencesHelper;
import com.leapord.architecture.model.prefs.PrefesHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PrefesHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, preferencesHelper);
    }

}
