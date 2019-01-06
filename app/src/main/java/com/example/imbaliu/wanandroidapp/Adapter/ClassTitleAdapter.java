package com.example.imbaliu.wanandroidapp.Adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ChildrenTitle;
import com.example.imbaliu.wanandroidapp.R;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： ClassTitleAdapter
 * 创建者： LFY
 * 创建时间： 2019/1/3 10:16
 * 描述：   TODO
 */

public class ClassTitleAdapter extends BaseQuickAdapter<ChildrenTitle, BaseViewHolder> {
    private OnClickListener onClickListener;

    public void setOnClickListen(OnClickListener onClickListen) {
        this.onClickListener = onClickListen;
    }

    public interface OnClickListener {
        void onClick(int position);
    }

    public ClassTitleAdapter(int layoutResId, @Nullable List<ChildrenTitle> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ChildrenTitle item) {
        helper.setText(R.id.item_classtitle, item.getName());
        View view =helper.getConvertView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(helper.getAdapterPosition());
            }
        });

    }
}
