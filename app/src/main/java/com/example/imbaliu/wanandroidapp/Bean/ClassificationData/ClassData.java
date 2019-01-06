package com.example.imbaliu.wanandroidapp.Bean.ClassificationData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.ClassificationData
 * 文件名： ClassData
 * 创建者： LFY
 * 创建时间： 2019/1/3 10:04
 * 描述：   TODO
 */

public class ClassData {
    @SerializedName("data")
    private List<ChildrenTitle> data;

    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

    public List<ChildrenTitle> getData() {
        return data;
    }

    public void setData(List<ChildrenTitle> data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
