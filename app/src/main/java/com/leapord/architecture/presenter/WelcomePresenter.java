package com.leapord.architecture.presenter;


import com.leapord.architecture.base.RxPresenter;
import com.leapord.architecture.base.contact.WelcomeContract;
import com.leapord.architecture.model.DataManager;
import com.leapord.architecture.model.bean.WelcomeBean;
import com.leapord.architecture.model.http.HttpResponse;
import com.leapord.architecture.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by codeest on 16/8/15.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {


    private static final int COUNT_DOWN_TIME = 2200;

    private DataManager mDataManager;

    @Inject
    public WelcomePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getWelcomeData() {
        addSubscribe(mDataManager.fetchWelcomeInfo()
                .compose(RxUtil.<HttpResponse<WelcomeBean>>rxSchedulerHelper())
                .compose(RxUtil.<WelcomeBean>handleResult())
                .subscribe(new Consumer<WelcomeBean>() {
                    @Override
                    public void accept(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.jumpToMain();
                    }
                })
        );

    }

    private void startCountDown() {
        addSubscribe(Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        mView.jumpToMain();
                    }
                })
        );
    }
}
