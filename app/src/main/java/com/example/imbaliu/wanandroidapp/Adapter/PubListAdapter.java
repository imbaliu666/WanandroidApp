package com.example.imbaliu.wanandroidapp.Adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.R;
import com.example.imbaliu.wanandroidapp.WebView.BaseWebView;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： PubListAdapter
 * 创建者： LFY
 * 创建时间： 2018/12/28 16:06
 * 描述：   TODO
 */

public class PubListAdapter extends BaseQuickAdapter<DataMain,BaseViewHolder> {
    public PubListAdapter(int layoutResId, @Nullable List<DataMain> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DataMain item) {
        View view =helper.getConvertView();
        helper.setText(R.id.item_list_title,item.getTitle());
        helper.setText(R.id.item_list_date,item.getNiceDate());
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
