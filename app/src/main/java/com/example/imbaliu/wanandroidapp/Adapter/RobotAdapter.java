package com.example.imbaliu.wanandroidapp.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.R;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： RobotAdapter
 * 创建者： LFY
 * 创建时间： 2019/2/19 16:59
 * 描述：   TODO
 */

public class RobotAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public RobotAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int position =helper.getAdapterPosition();
        if (position%2>0) {
            helper.setVisible(R.id.item_left,true);
            helper.setText(R.id.left_text, item);
        }else {
            helper.setVisible(R.id.item_right,true);
            helper.setText(R.id.right_text, item);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
