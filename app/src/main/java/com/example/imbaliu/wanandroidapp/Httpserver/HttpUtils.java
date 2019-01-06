package com.example.imbaliu.wanandroidapp.Httpserver;

import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ChildrenTitle;
import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ClassData;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.PubData.Author;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Httpserver
 * 文件名： HttpUtils
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:37
 * 描述：   TODO
 */

public class HttpUtils {

    private Observer<Data> observer;


    private final static String url ="http://www.wanandroid.com/";

    /**
     * 首页
     */

    public static void request(String urlress,Observer<Data> observer){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

       Apiserver request = retrofit.create(Apiserver.class);
        io.reactivex.Observable<Data> call = request.getCall(urlress);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    /**
     * 公众号作者
     *
     */
    public static void requestPubAuthor(String urlress,Observer<Author> observer){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Apiserver request = retrofit.create(Apiserver.class);
        io.reactivex.Observable<Author> call = request.getPubAuthor(urlress);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    /**
     * 体系标题
     */
    public static void requestClass(String urlress,Observer<ClassData> observer){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Apiserver request = retrofit.create(Apiserver.class);
        io.reactivex.Observable<ClassData> call = request.getClassData(urlress);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
