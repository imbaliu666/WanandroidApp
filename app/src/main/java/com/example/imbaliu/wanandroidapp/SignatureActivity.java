package com.example.imbaliu.wanandroidapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.imbaliu.wanandroidapp.Event.BitmapEvent;
import com.example.imbaliu.wanandroidapp.InitView.SignatureView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp
 * 文件名： SignatureActivity
 * 创建者： LFY
 * 创建时间： 2018/12/29 15:39
 * 描述：   TODO
 */

public class SignatureActivity extends BaseActivity {

    @BindView(R.id.edit_img)
    FrameLayout mframelayout;

    @BindView(R.id.sig_clear)
    Button clearbutton;

    private SignatureView signatureView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        signatureView=new SignatureView(this);
        mframelayout.addView(signatureView);
    }

    @OnClick({R.id.sig_clear,R.id.sig_finish})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.sig_clear:
                signatureView.clear();
                break;
            case R.id.sig_finish:
                Bitmap bitmap = signatureView.getCachebBitmap();
                EventBus.getDefault().post(new BitmapEvent(bitmap));
                finish();
                break;


            default:
                    break;


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
