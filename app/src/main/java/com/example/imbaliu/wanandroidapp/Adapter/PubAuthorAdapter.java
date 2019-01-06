package com.example.imbaliu.wanandroidapp.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imbaliu.wanandroidapp.Bean.PubData.Author;
import com.example.imbaliu.wanandroidapp.R;

import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Adapter
 * 文件名： PubAuthorAdapter
 * 创建者： LFY
 * 创建时间： 2018/12/28 15:30
 * 描述：   TODO
 */

public class PubAuthorAdapter extends BaseQuickAdapter<Author.AuthorData,BaseViewHolder> {

private OnClickListener onClickListener;
private int type;

    public interface OnClickListener{
        void intent(int id);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

    public PubAuthorAdapter(int layoutResId, @Nullable List<Author.AuthorData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final Author.AuthorData item) {
        if (type ==helper.getAdapterPosition()){
            helper.setTextColor(R.id.item_pub_author, mContext.getResources().getColor(R.color.blue_9134240));
        }else {
            helper.setTextColor(R.id.item_pub_author, mContext.getResources().getColor(R.color.grey_153153153));

        }
        helper.setText(R.id.item_pub_author,item.getName());
        helper.setOnClickListener(R.id.item_pub_author, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type=helper.getAdapterPosition();
               onClickListener.intent(item.getId());
               notifyDataSetChanged();
            }
        });
    }


}
