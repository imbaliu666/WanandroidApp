package com.example.imbaliu.wanandroidapp.Adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ChildrenTitle;
import com.example.imbaliu.wanandroidapp.Bean.PubData.Author;
import com.example.imbaliu.wanandroidapp.R;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： ClassSecTitleAdapter
 * 创建者： LFY
 * 创建时间： 2019/1/3 11:05
 * 描述：   TODO
 */

public class ClassSecTitleAdapter extends BaseQuickAdapter<ChildrenTitle, BaseViewHolder> {
    int type = 0;
    private OnClickListen onClickListen;

    public interface OnClickListen {
        void onClick(int cid);
    }

    public void setOnClickListen(OnClickListen onClickListen) {
        this.onClickListen = onClickListen;


    }

    public ClassSecTitleAdapter(int layoutResId, @Nullable List<ChildrenTitle> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ChildrenTitle item) {
        if (type == helper.getAdapterPosition()) {
            helper.setTextColor(R.id.item_pub_author, mContext.getResources().getColor(R.color.blue_9134240));
        } else {
            helper.setTextColor(R.id.item_pub_author, mContext.getResources().getColor(R.color.grey_153153153));

        }
        helper.setText(R.id.item_pub_author, item.getName());
        View view = helper.getConvertView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListen.onClick(item.getId());
                type = helper.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }
}
