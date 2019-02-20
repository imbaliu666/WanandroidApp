package com.example.imbaliu.wanandroidapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.imbaliu.wanandroidapp.Event.BitmapEvent;
import com.example.imbaliu.wanandroidapp.NoteBook.NoteBookActivity;
import com.example.imbaliu.wanandroidapp.R;
import com.example.imbaliu.wanandroidapp.SignatureActivity;
import com.example.imbaliu.wanandroidapp.SurfaceViewAcitvity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： PersonFragment
 * 创建者： LFY
 * 创建时间： 2018/12/28 17:49
 * 描述：   TODO
 */

public class PersonFragment extends BaseFragment {
    @BindView(R.id.personal_img)
    CircleImageView personImg;

    @BindView(R.id.persion_note)
    TextView persionNote;

    @BindView(R.id.run_ball)
    TextView runBall;

    @Override
    public int onGetLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @OnClick({R.id.personal_img,R.id.persion_note,R.id.run_ball})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.personal_img:
                startActivity(new Intent(getActivity(), SignatureActivity.class));
                break;
            case R.id.persion_note:
                Intent intent =new Intent(getActivity(), NoteBookActivity.class);
                startActivity(intent);
                break;
            case R.id.run_ball:
                startActivity(new Intent(getActivity(), SurfaceViewAcitvity.class));
                break;

            default:
                break;
        }


    }

    @Subscribe
    public void onEvent(BitmapEvent bitmapEvent) {
        personImg.setImageBitmap(bitmapEvent.getBitmap());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
