package com.example.imbaliu.wanandroidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp
 * 文件名： BaseActivity
 * 创建者： LFY
 * 创建时间： 2018/12/28 11:32
 * 描述：   TODO
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar =getSupportActionBar();
        if (actionBar !=null) {
            actionBar.hide();
        }
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
