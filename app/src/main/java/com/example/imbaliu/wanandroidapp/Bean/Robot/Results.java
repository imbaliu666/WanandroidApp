package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： Results
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:58
 * 描述：   TODO
 */

public class Results {

    @SerializedName("groupType")
    private int groupType;
    @SerializedName("resultType")
    private String resultType;
    @SerializedName("values")
    private ResultValue values;

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public ResultValue getValues() {
        return values;
    }

    public void setValues(ResultValue values) {
        this.values = values;
    }
}
