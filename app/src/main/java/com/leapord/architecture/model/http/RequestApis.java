package com.leapord.architecture.model.http;


import com.leapord.architecture.model.bean.VersionBean;
import com.leapord.architecture.model.bean.WelcomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by codeest on 2016/8/2.
 * 知乎APIs
 */
public interface RequestApis {

    String HOST = "http://mx.liujingongchang.com/jackey";

    /**
     * 启动界面图片
     */
    @GET("/config/getLoanConfig")
    Observable<HttpResponse<WelcomeBean>> getWelcomeInfo();

    @POST("/config/getLatestVersion")
    Observable<HttpResponse<VersionBean>> getVersionInfo();
}
