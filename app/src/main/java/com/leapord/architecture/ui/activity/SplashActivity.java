package com.leapord.architecture.ui.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.leapord.architecture.R;
import com.leapord.architecture.base.BaseActivity;
import com.leapord.architecture.base.contact.WelcomeContract;
import com.leapord.architecture.di.component.ActivityComponent;
import com.leapord.architecture.model.bean.WelcomeBean;
import com.leapord.architecture.presenter.WelcomePresenter;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {
    @BindView(R.id.iv_welcome)
    ImageView ivWelcome;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ivWelcome.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void inject(ActivityComponent component) {
        component.inject(this);
    }
}
