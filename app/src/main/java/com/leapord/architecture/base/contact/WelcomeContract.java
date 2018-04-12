package com.leapord.architecture.base.contact;

import com.leapord.architecture.base.BasePresenter;
import com.leapord.architecture.base.BaseView;
import com.leapord.architecture.model.bean.WelcomeBean;

/**
 * Created by codeest on 16/8/15.
 */

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
