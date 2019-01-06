package com.example.imbaliu.wanandroidapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Utils
 * 文件名： ShareUtils
 * 创建者： LFY
 * 创建时间： 2019/1/2 8:56
 * 描述：   TODO
 */

public class ShareUtils {
    private final static String PLAYINGANDROID ="playingandroid";

    public static void putString(Context context,String key,String value){
        SharedPreferences.Editor editor = context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static String getString(Context context,String key){
        SharedPreferences preferences =context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE);
        return preferences.getString(key,"数据不存在");
    }

    public static void putInt(Context context,String key,int value){
        SharedPreferences.Editor editor = context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE).edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static int getInt(Context context,String key){
        SharedPreferences preferences =context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE);
        return preferences.getInt(key,-1);
    }

    public static void putBoolean(Context context,String key,Boolean value){
        SharedPreferences.Editor editor = context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE).edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static Boolean getBoolean(Context context,String key){
        SharedPreferences preferences =context.getSharedPreferences(PLAYINGANDROID,Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }

}
