package com.example.imbaliu.wanandroidapp.Event;

import android.graphics.Bitmap;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Event
 * 文件名： BitmapEvent
 * 创建者： LFY
 * 创建时间： 2018/12/29 17:11
 * 描述：   TODO
 */

public class BitmapEvent {
    private Bitmap bitmap;

    public BitmapEvent(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
