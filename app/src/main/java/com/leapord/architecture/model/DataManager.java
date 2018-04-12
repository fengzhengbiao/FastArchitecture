package com.leapord.architecture.model;


import com.leapord.architecture.model.bean.VersionBean;
import com.leapord.architecture.model.bean.WelcomeBean;
import com.leapord.architecture.model.http.HttpHelper;
import com.leapord.architecture.model.http.HttpResponse;
import com.leapord.architecture.model.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataManager implements HttpHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public Observable<HttpResponse<WelcomeBean>> fetchWelcomeInfo() {
        return mHttpHelper.fetchWelcomeInfo();
    }
    @Override
    public Observable<HttpResponse<VersionBean>> fetchVersionInfo() {
        return mHttpHelper.fetchVersionInfo();
    }
}
