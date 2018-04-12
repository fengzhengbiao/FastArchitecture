package com.leapord.architecture.presenter;

import android.Manifest;

import com.leapord.architecture.base.RxPresenter;
import com.leapord.architecture.base.contact.MainContract;
import com.leapord.architecture.model.DataManager;
import com.leapord.architecture.model.bean.VersionBean;
import com.leapord.architecture.model.http.ApiException;
import com.leapord.architecture.model.http.HttpResponse;
import com.leapord.architecture.util.RxUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import retrofit2.HttpException;

/**
 * Created by codeest on 16/8/9.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void checkVersion(final String currentVersion) {
        addSubscribe(mDataManager.fetchVersionInfo()
                .compose(RxUtil.<HttpResponse<VersionBean>>rxSchedulerHelper())
                .compose(RxUtil.<VersionBean>handleResult())
                .filter(new Predicate<VersionBean>() {
                    @Override
                    public boolean test(@NonNull VersionBean versionBean) throws Exception {
                        return Integer.valueOf(currentVersion.replace(".", "")) < Integer.valueOf(versionBean.getCode().replace(".", ""));
                    }
                })
                .map(new Function<VersionBean, String>() {
                    @Override
                    public String apply(VersionBean bean) {
                        StringBuilder content = new StringBuilder("版本号: v");
                        content.append(bean.getCode());
                        content.append("\r\n");
                        content.append("版本大小: ");
                        content.append(bean.getSize());
                        content.append("\r\n");
                        content.append("更新内容:\r\n");
                        content.append(bean.getDes().replace("\\r\\n", "\r\n"));
                        return content.toString();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        if (throwable != null) {
                            mView.showErrorMsg(throwable.toString());
                        } else if (throwable instanceof ApiException) {
                            mView.showErrorMsg(throwable.toString());
                        } else if (throwable instanceof HttpException) {
                            mView.showErrorMsg("数据加载失败ヽ(≧Д≦)ノ");
                        } else {
                            mView.showErrorMsg("未知错误ヽ(≧Д≦)ノ");
                        }
                    }
                })
        );
    }

    @Override
    public void checkPermissions(RxPermissions rxPermissions) {
        addSubscribe(rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) {
                        if (granted) {
                            mView.startDownloadService();
                        } else {
                            mView.showErrorMsg("下载应用需要文件写入权限哦~");
                        }
                    }
                })
        );
    }


}
