package com.example.imbaliu.wanandroidapp.Bean.PubData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.PubData
 * 文件名： Author
 * 创建者： LFY
 * 创建时间： 2018/12/28 15:21
 * 描述：   TODO
 */

public class Author {

    @SerializedName("data")
    private List<AuthorData> data;

    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

    public List<AuthorData> getData() {
        return data;
    }

    public void setData(List<AuthorData> data) {
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

    public class AuthorData{

        @SerializedName("name")
        private String name;

        @SerializedName("id")
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }






}
