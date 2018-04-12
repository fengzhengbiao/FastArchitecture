package com.leapord.architecture.model.http;

import com.leapord.architecture.model.bean.VersionBean;
import com.leapord.architecture.model.bean.WelcomeBean;

import io.reactivex.Observable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper  {

    Observable<HttpResponse<WelcomeBean>> fetchWelcomeInfo();

    Observable<HttpResponse<VersionBean>> fetchVersionInfo();

}
