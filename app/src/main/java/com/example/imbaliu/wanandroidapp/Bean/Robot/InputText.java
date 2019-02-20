package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： InputText
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:51
 * 描述：   TODO
 */

public class InputText {

    @SerializedName("text")
    private String text;

    public InputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
