package com.example.imbaliu.wanandroidapp;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp
 * 文件名： BaseSubscriber
 * 创建者： LFY
 * 创建时间： 2018/12/28 17:10
 * 描述：   TODO
 */

public abstract class BaseSubscriber<T> implements Observer<T> {

    public abstract void onDoNext(T t);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
         onDoNext(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
