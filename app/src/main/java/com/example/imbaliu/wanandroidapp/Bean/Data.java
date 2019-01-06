package com.example.imbaliu.wanandroidapp.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean
 * 文件名： Data
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:26
 * 描述：   TODO
 */

public class Data {
    @SerializedName("data")
    private DataInfo data;
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }
}
