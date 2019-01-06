package com.example.imbaliu.wanandroidapp.Bean.ClassificationData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean.PubData
 * 文件名： ChildrenTitle
 * 创建者： LFY
 * 创建时间： 2019/1/3 10:06
 * 描述：   TODO
 */

public class ChildrenTitle {
    @SerializedName("children")
    private List<ChildrenTitle> children;

    @SerializedName("courseId")
    private int courseId;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private int order;

    @SerializedName("parentChapterId")
    private int parentChapterId;

    @SerializedName("userControlSetTop")
    private boolean userControlSetTop;

    @SerializedName("visible")
    private int visible;

    public List<ChildrenTitle> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenTitle> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
