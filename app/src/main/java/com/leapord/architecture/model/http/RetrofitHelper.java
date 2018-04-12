package com.leapord.architecture.model.http;

import com.leapord.architecture.model.bean.VersionBean;
import com.leapord.architecture.model.bean.WelcomeBean;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper implements HttpHelper {

    private RequestApis mRequestApis;


    @Inject
    public RetrofitHelper(RequestApis requestService) {
        this.mRequestApis = requestService;
    }

    @Override
    public  Observable<HttpResponse<WelcomeBean>> fetchWelcomeInfo() {
        return mRequestApis.getWelcomeInfo();
    }

    @Override
    public Observable<HttpResponse<VersionBean>> fetchVersionInfo() {
        return mRequestApis.getVersionInfo();
    }

}
