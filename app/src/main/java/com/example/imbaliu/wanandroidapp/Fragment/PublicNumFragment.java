package com.example.imbaliu.wanandroidapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imbaliu.wanandroidapp.Adapter.PubAuthorAdapter;
import com.example.imbaliu.wanandroidapp.Adapter.PubListAdapter;
import com.example.imbaliu.wanandroidapp.BaseSubscriber;
import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Bean.PubData.Author;
import com.example.imbaliu.wanandroidapp.Httpserver.HttpUtils;
import com.example.imbaliu.wanandroidapp.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： PublicNumFragment
 * 创建者： LFY
 * 创建时间： 2018/12/26 15:37
 * 描述：   TODO
 */

public class PublicNumFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.pub_refresh)
    SmartRefreshLayout pubRefresh;
    @BindView(R.id.pub_author)
    RecyclerView recyclerAu;
    @BindView(R.id.pub_list)
    RecyclerView recyclerLi;
    PubAuthorAdapter adapter;

    PubListAdapter pubadapter;

    /**
     * 保存Author
     */
    List<Author.AuthorData> mList;

    /**
     * 保存文章List
     */
    List<DataMain> dataMainList;

    /**
     * 作者id
     */
    int authorId;

    /**
     * 文章页数
     */
    int page = 1;


    @Override
    public int onGetLayout() {
        return R.layout.fragment_public;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pubRefresh.setOnRefreshListener(this);
        pubRefresh.setOnLoadMoreListener(this);
        initdata();
        initList();

    }

    private void initList() {

        HttpUtils.request("wxarticle/list/408/1/json", new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerLi.setLayoutManager(layoutManager);
                dataMainList = data.getData().getDatas();
                pubadapter = new PubListAdapter(R.layout.item_pub_list, dataMainList);
                recyclerLi.setAdapter(pubadapter);
                recyclerLi.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            }
        });


    }


    /**
     * 请求公众号作者信息
     */
    private void initdata() {
        HttpUtils.requestPubAuthor("wxarticle/chapters/json", new BaseSubscriber<Author>() {
            @Override
            public void onDoNext(Author author) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerAu.setLayoutManager(layoutManager);
                mList = author.getData();
                adapter = new PubAuthorAdapter(R.layout.item_pub_author, mList);
                recyclerAu.setAdapter(adapter);
                authorId=author.getData().get(0).getId();
                adapter.setOnClickListener(new PubAuthorAdapter.OnClickListener() {
                    @Override
                    public void intent(int id) {
                        authorId = id;
                        requestList(id);
                    }
                });
            }
        });


    }

    private void requestList(int id) {
        HttpUtils.request("wxarticle/list/" + id + "/1/json", new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                if (data.getData().getDatas()!=null) {
                    dataMainList = data.getData().getDatas();
                    pubadapter.setNewData(dataMainList);
                    recyclerLi.scrollToPosition(0);
                }
            }
        });


    }

    /**
     * 上拉加载
     */

    private void onLoad() {
        page++;
        HttpUtils.request("wxarticle/list/" + authorId + "/" + page + "/json", new BaseSubscriber<Data>() {
            @Override
            public void onDoNext(Data data) {
                if (data.getData().getDatas()!=null) {
                    pubadapter.addData(data.getData().getDatas());
                }
            }
        });
    }


    private void changeTextColor(TextView textView, int start, int end, String text) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.colorPrimary)), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        onLoad();
        pubRefresh.finishLoadMore(2000);

    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        requestList(authorId);
        pubRefresh.finishRefresh(2000);

    }
}
