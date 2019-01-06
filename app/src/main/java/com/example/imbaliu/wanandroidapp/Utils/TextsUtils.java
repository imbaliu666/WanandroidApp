package com.example.imbaliu.wanandroidapp.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.imbaliu.wanandroidapp.R;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Utils
 * 文件名： TextsUtils
 * 创建者： LFY
 * 创建时间： 2018/12/28 9:27
 * 描述：   TODO
 */

public class TextsUtils {

    /**
     * 富文本
     */
    public static void changeTextColor(Context context, TextView textView, int start, int end, String text) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorPrimary)), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    /**
     * 设置字体
     */
    public static void setFont(Context mContext, TextView textView) {
        //设置字体
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/58pic_53bb331fd1232.TTF");
        textView.setTypeface(typeface);

    }
}
