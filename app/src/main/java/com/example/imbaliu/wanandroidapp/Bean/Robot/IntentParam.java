package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： IntentParam
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:56
 * 描述：   TODO
 */

public class IntentParam {
    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
