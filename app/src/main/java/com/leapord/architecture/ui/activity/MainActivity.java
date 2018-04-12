package com.leapord.architecture.ui.activity;

import com.leapord.architecture.R;
import com.leapord.architecture.base.BaseActivity;
import com.leapord.architecture.base.contact.MainContract;
import com.leapord.architecture.di.component.ActivityComponent;
import com.leapord.architecture.presenter.MainPresenter;
import com.leapord.architecture.util.ToastUtils;

/**
 * @author JokerFish
 * @date 2017/10/23
 * @description
 * @email fengzhengbiao@vcard100.com
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @Override
    public void showUpdateDialog(String versionContent) {
        ToastUtils.showToast(versionContent);
    }

    @Override
    public void startDownloadService() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.checkVersion("1.0.0");
    }

    @Override
    public void inject(ActivityComponent component) {
        component.inject(this);
    }
}
