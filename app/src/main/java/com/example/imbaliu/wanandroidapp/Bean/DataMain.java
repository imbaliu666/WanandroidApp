package com.example.imbaliu.wanandroidapp.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Bean
 * 文件名： DataMain
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:32
 * 描述：   TODO
 */

public class DataMain implements Parcelable {

    @SerializedName("author")
    private String author;

    @SerializedName("link")
    private String link;

    @SerializedName("niceDate")
    private String niceDate;

    @SerializedName("title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.link);
        dest.writeString(this.niceDate);
        dest.writeString(this.title);
    }

    public DataMain() {
    }

    public DataMain(String author, String link, String niceDate, String title) {
        this.author = author;
        this.link = link;
        this.niceDate = niceDate;
        this.title = title;
    }

    protected DataMain(Parcel in) {
        this.author = in.readString();
        this.link = in.readString();
        this.niceDate = in.readString();
        this.title = in.readString();
    }

    public static final Creator<DataMain> CREATOR = new Creator<DataMain>() {
        @Override
        public DataMain createFromParcel(Parcel source) {
            return new DataMain(source);
        }

        @Override
        public DataMain[] newArray(int size) {
            return new DataMain[size];
        }
    };
}
