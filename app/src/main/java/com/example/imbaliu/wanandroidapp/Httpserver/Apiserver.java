package com.example.imbaliu.wanandroidapp.Httpserver;

import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ClassData;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.PubData.Author;
import com.example.imbaliu.wanandroidapp.Bean.Robot.RobotRequest;
import com.example.imbaliu.wanandroidapp.Bean.Robot.RobotResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Httpserver
 * 文件名： Apiserver
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:35
 * 描述：   TODO
 */

public interface Apiserver {


    /**
     * 首页查询
     */
    @GET()
    Observable<Data> getCall(@Url String url);

    /**
     * 公众号作者查询
     */
    @GET()
    Observable<Author> getPubAuthor(@Url String url);

    /**
     * 体系查询
     */
    @GET()
    Observable<ClassData> getClassData(@Url String url);
    /**
     * 机器人
     */
    @POST()
    Observable<RobotResponse> getRobot(@Url String url, @Body RobotRequest request);
}
