package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： RobotResponse
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:53
 * 描述：   TODO
 */

public class RobotResponse {
    @SerializedName("intent")
    private IntentParam intent;
    @SerializedName("results")
    private List<Results> results;

    public IntentParam getIntent() {
        return intent;
    }

    public void setIntent(IntentParam intent) {
        this.intent = intent;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
