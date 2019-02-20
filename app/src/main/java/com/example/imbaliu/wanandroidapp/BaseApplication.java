package com.example.imbaliu.wanandroidapp;

import android.app.Application;

import com.didichuxing.doraemonkit.DoraemonKit;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp
 * 文件名： BaseApplication
 * 创建者： LFY
 * 创建时间： 2018/12/26 15:29
 * 描述：   TODO
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DoraemonKit.install(this);


    }
}
