package com.example.imbaliu.wanandroidapp.Bean.Robot;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.Robot
 * 文件名： Perception
 * 创建者： LFY
 * 创建时间： 2019/2/18 17:46
 * 描述：   TODO
 */

public class Perception {

    @SerializedName("inputText")
    private InputText inputText;


    public InputText getInputText() {
        return inputText;
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }


}
