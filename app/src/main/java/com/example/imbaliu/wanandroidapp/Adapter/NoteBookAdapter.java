package com.example.imbaliu.wanandroidapp.Adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.R;
import com.example.imbaliu.wanandroidapp.WebView.BaseWebView;

import java.util.List;

import butterknife.OnClick;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： NoteBookAdapter
 * 创建者： LFY
 * 创建时间： 2019/1/2 16:55
 * 描述：   TODO
 */

public class NoteBookAdapter extends BaseQuickAdapter<DataMain,BaseViewHolder> {
    private OnClickListener onClickListener;

    public NoteBookAdapter(int layoutResId, @Nullable List<DataMain> data) {
        super(layoutResId, data);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;

    }
    public interface OnClickListener{

        void delete(int position);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DataMain item) {
        helper.setText(R.id.item_main_title,item.getTitle());
        helper.setText(R.id.item_main_author,item.getAuthor());
        helper.setText(R.id.item_main_time,item.getNiceDate());
        helper.setOnClickListener(R.id.btnDelete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.delete(helper.getAdapterPosition());
            }
        });
        helper.setOnClickListener(R.id.item_main_title, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext,BaseWebView.class);
                intent.putExtra(BaseWebView.WEBVIEW_FLAG,item);
                mContext.startActivity(intent);

            }
        });

    }
}
