package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： UserInfo
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:50
 * 描述：   TODO
 */

public class UserInfo {
    @SerializedName("apiKey")
    private String apiKey;

    @SerializedName("userId")
    private String userId;

    public UserInfo(String apiKey, String userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
