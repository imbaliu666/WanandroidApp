package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： ResultValue
 * 创建者： LFY
 * 创建时间： 2019/2/18 18:00
 * 描述：   TODO
 */

public class ResultValue {
    @SerializedName("text")
    private String text;
    @SerializedName("url")
    private String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
