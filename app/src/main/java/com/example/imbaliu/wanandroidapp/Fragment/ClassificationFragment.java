package com.example.imbaliu.wanandroidapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.imbaliu.wanandroidapp.Adapter.ClassSecTitleAdapter;
import com.example.imbaliu.wanandroidapp.Adapter.ClassTitleAdapter;
import com.example.imbaliu.wanandroidapp.Adapter.PubListAdapter;
import com.example.imbaliu.wanandroidapp.BaseSubscriber;
import com.example.imbaliu.wanandroidapp.Bean.ClassificationData.ClassData;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Httpserver.HttpUtils;
import com.example.imbaliu.wanandroidapp.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： ClassificationFragment
 * 创建者： LFY
 * 创建时间： 2018/12/30 12:13
 * 描述：   TODO
 */

public class ClassificationFragment extends BaseFragment implements OnLoadMoreListener,OnRefreshListener {
   /**
    * 一级栏目
    */
    private ClassTitleAdapter adapter;

    /**
     * 二级栏目
     */
    private ClassSecTitleAdapter classSecTitleAdapter;

    /**
     * 栏目内容
     */
    private PubListAdapter pubListAdapter;

    /**
     * 内容id
     */
    private int contentid =60;

    /**
     * 内容当前页
     */
    private int page=1;
    @BindView(R.id.class_sectitle)
    RecyclerView reSecTitle;

    @BindView(R.id.class_content)
    RecyclerView reContent;


    @BindView(R.id.class_title_re)
    RecyclerView recyclerView;

    @BindView(R.id.pub_refresh)
    SmartRefreshLayout pubRefresh;


    @Override
    public int onGetLayout() {
        return R.layout.fragment_class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pubRefresh.setOnLoadMoreListener(this);
        pubRefresh.setOnRefreshListener(this);
        initView();
        initList();
    }

    private void initList() {
        classSecTitleAdapter = new ClassSecTitleAdapter(R.layout.item_pub_author, null);
        classSecTitleAdapter.setOnClickListen(new ClassSecTitleAdapter.OnClickListen() {
            @Override
            public void onClick(int cid) {
                contentid=cid;
                HttpUtils.request("article/list/0/json?cid="+cid, new BaseSubscriber<Data>() {
                    @Override
                    public void onDoNext(Data data) {
                        pubListAdapter.setNewData(data.getData().getDatas());
                    }
                });
            }
        });
    }

    /**
     * 加载数据
     */
    private void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reSecTitle.setLayoutManager(layoutManager);
        reContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        reContent.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        HttpUtils.requestClass("tree/json/", new BaseSubscriber<ClassData>() {
            @Override
            public void onDoNext(final ClassData classData) {
                if (classData != null) {
                    adapter = new ClassTitleAdapter(R.layout.item_classtitle, classData.getData());
                    classSecTitleAdapter.setNewData( classData.getData().get(0).getChildren());
                    contentid=classData.getData().get(0).getChildren().get(0).getId();
                    reSecTitle.setAdapter(classSecTitleAdapter);
                    recyclerView.setAdapter(adapter);
                    HttpUtils.request("article/list/0/json?cid="+classData.getData().get(0).getChildren().get(0).getId(), new BaseSubscriber<Data>() {
                        @Override
                        public void onDoNext(Data data) {
                            pubListAdapter =new PubListAdapter(R.layout.item_pub_list,data.getData().getDatas());
                            reContent.setAdapter(pubListAdapter);
                        }
                    });
                    adapter.setOnClickListen(new ClassTitleAdapter.OnClickListener() {
                        @Override
                        public void onClick(int position) {
                            reSecTitle.scrollToPosition(0);
                            classSecTitleAdapter.setNewData(classData.getData().get(position).getChildren());
                            contentid=classData.getData().get(position).getChildren().get(0).getId();
                            HttpUtils.request("article/list/0/json?cid="+classData.getData().get(position).getChildren().get(0).getId(), new BaseSubscriber<Data>() {
                                @Override
                                public void onDoNext(Data data) {
                                    pubListAdapter.setNewData(data.getData().getDatas());
                                }
                            });

                        }
                    });

                }
            }
        });


    }

    /**
     * 上拉加载
     */
    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        page++;
        HttpUtils.request("article/list/"+page+"/json?cid="+contentid, new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                if (data.getData().getDatas() != null) {
                    pubListAdapter.addData(data.getData().getDatas());
                }
            }
        });
        pubRefresh.finishLoadMore(2000);

    }

    /**
     * 下拉刷新
     */

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        pubRefresh.finishRefresh(2000);


    }
}
