package com.example.imbaliu.wanandroidapp.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean
 * 文件名： DataInfo
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:30
 * 描述：   TODO
 */

public class DataInfo {
    @SerializedName("curPage")
    private int curPage;

    @SerializedName("datas")
    private List<DataMain> datas;

    @SerializedName("offset")
    private int offset;

    @SerializedName("over")
    private boolean over;

    @SerializedName("pageCount")
    private int pageCount;

    @SerializedName("size")
    private int size;

    @SerializedName("total")
    private int total;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<DataMain> getDatas() {
        return datas;
    }

    public void setDatas(List<DataMain> datas) {
        this.datas = datas;
    }
}
