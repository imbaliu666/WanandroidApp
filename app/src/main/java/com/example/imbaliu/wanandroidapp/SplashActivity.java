package com.example.imbaliu.wanandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.imbaliu.wanandroidapp.Utils.TextsUtils;

import butterknife.BindView;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp
 * 文件名： SplashActivity
 * 创建者： LFY
 * 创建时间： 2019/1/1 22:45
 * 描述：   TODO
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash_text)
    TextView splashText;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        TextsUtils.setFont(this,splashText);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },1000);
    }

}
