package com.example.imbaliu.wanandroidapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.imbaliu.wanandroidapp.Adapter.MainAdapter;
import com.example.imbaliu.wanandroidapp.BaseSubscriber;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Httpserver.HttpUtils;
import com.example.imbaliu.wanandroidapp.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： MainFragment
 * 创建者： LFY
 * 创建时间： 2018/12/26 15:33
 * 描述：   TODO
 */

public class MainFragment extends BaseFragment implements OnRefreshListener,OnLoadMoreListener {

    private RecyclerView recyclerView;

    private List<DataMain> mDataMain;

    private int page =0;

    private MainAdapter adapter;

    @BindView(R.id.swip_refresh)
    SmartRefreshLayout swipeRefreshLayout;


    @Override
    public int onGetLayout() {
        return R.layout.fragment_main;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.main_recycler);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setOnLoadMoreListener(this);
        initData();

    }


    private void initData() {
        HttpUtils.request("article/list/0/json/", new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                if (data != null) {
                    mDataMain=data.getData().getDatas();
                     adapter = new MainAdapter(R.layout.item_main,mDataMain);
                    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
//                    recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);

                }
            }
        });


    }

    /**
     * 上拉加载
     */
    private void onLoad(){
        page++;
        HttpUtils.request("article/list/" + page + "/json/", new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                if (data.getData().getDatas() !=null) {
                    adapter.addData(data.getData().getDatas());
                }
            }
        });

    }



    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        initData();
        swipeRefreshLayout.finishRefresh(2000);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        onLoad();
        swipeRefreshLayout.finishLoadMore(2000);
    }
}
