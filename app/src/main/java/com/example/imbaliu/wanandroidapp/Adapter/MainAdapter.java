package com.example.imbaliu.wanandroidapp.Adapter;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.DataInfo;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.R;
import com.example.imbaliu.wanandroidapp.WebView.BaseWebView;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： MainAdapter
 * 创建者： LFY
 * 创建时间： 2018/12/26 16:46
 * 描述：   TODO
 */

public class MainAdapter extends BaseQuickAdapter<DataMain,BaseViewHolder> {
    public MainAdapter(int layoutResId, @Nullable List<DataMain> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DataMain item) {
        View view=helper.getConvertView();
        helper.setText(R.id.item_main_title,item.getTitle());
        helper.setText(R.id.item_main_author,item.getAuthor());
        helper.setText(R.id.item_main_time,item.getNiceDate());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext,BaseWebView.class);
                intent.putExtra(BaseWebView.WEBVIEW_FLAG,item);
                mContext.startActivity(intent);


            }

        });

    }
}
