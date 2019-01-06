package com.example.imbaliu.wanandroidapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： BaseFragment
 * 创建者： LFY
 * 创建时间： 2018/12/26 15:34
 * 描述：   TODO
 */

public class BaseFragment extends Fragment {
    private Unbinder unbinder;


    public int onGetLayout(){
        return -1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (onGetLayout() !=-1){
            View view =inflater.inflate(onGetLayout(),container,false);
            unbinder=ButterKnife.bind(this,view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != unbinder)
            unbinder.unbind();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
