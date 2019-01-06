package com.example.imbaliu.wanandroidapp.WebView;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.imbaliu.wanandroidapp.BaseActivity;
import com.example.imbaliu.wanandroidapp.Bean.DataMain;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.WebView
 * 文件名： BaseWebView
 * 创建者： LFY
 * 创建时间： 2018/12/26 21:34
 * 描述：   TODO
 */

public class BaseWebView extends BaseActivity {

    @BindView(R.id.web_view)
    WebView webView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.web_floating)
    FloatingActionButton webFloading;
    public final static String WEBVIEW_FLAG = "webviewflag";
    private DataMain dataMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basewebview);
        ButterKnife.bind(this);
        webView = findViewById(R.id.web_view);
        progressBar = findViewById(R.id.progressbar);
        dataMain=getIntent().getParcelableExtra(WEBVIEW_FLAG);
        initView(dataMain);
    }

    @OnClick(R.id.web_floating)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.web_floating:
                DatabaseHelper.addData(this,dataMain);
                Toast.makeText(this,"添加至笔记",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }

    private void initView(DataMain data) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        });
        webView.loadUrl(data.getLink());

    }


}
