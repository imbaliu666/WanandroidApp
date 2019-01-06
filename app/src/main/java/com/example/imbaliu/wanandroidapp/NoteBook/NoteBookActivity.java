package com.example.imbaliu.wanandroidapp.NoteBook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.imbaliu.wanandroidapp.Adapter.MainAdapter;
import com.example.imbaliu.wanandroidapp.Adapter.NoteBookAdapter;
import com.example.imbaliu.wanandroidapp.BaseActivity;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.NoteBook
 * 文件名： NoteBookActivity
 * 创建者： LFY
 * 创建时间： 2019/1/2 15:15
 * 描述：   TODO
 */

public class NoteBookActivity extends BaseActivity {
    private DatabaseHelper dbhelper;
    private List<DataMain> mainList ;

    @BindView(R.id.note_recycler)
    RecyclerView noteRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);
        initView();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        noteRecycler.setLayoutManager(layoutManager);
        mainList = DatabaseHelper.queryData(this);
        final NoteBookAdapter adapter = new NoteBookAdapter(R.layout.item_note, mainList);
        noteRecycler.setAdapter(adapter);
        adapter.setOnClickListener(new NoteBookAdapter.OnClickListener() {
            @Override
            public void delete(int position) {
                DatabaseHelper.deleteData(NoteBookActivity.this,mainList.get(position).getTitle());
                mainList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }


}
