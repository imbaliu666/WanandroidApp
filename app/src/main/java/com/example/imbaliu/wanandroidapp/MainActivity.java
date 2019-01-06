package com.example.imbaliu.wanandroidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.example.imbaliu.wanandroidapp.Bean.Data;
import com.example.imbaliu.wanandroidapp.Database.DatabaseHelper;
import com.example.imbaliu.wanandroidapp.Event.BitmapEvent;
import com.example.imbaliu.wanandroidapp.Fragment.ClassificationFragment;
import com.example.imbaliu.wanandroidapp.Fragment.MainFragment;
import com.example.imbaliu.wanandroidapp.Fragment.PublicNumFragment;
import com.example.imbaliu.wanandroidapp.Httpserver.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rx.internal.schedulers.NewThreadWorker;


public class MainActivity extends BaseActivity {
    /**
     * 主界面tablayout
     */
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.profile_image)
    CircleImageView profileimage;

    @BindView(R.id.content_view)
    DrawerLayout contentView;

    /**
     * Fragment列表
     */
    private List<Fragment> fragments = new ArrayList<>();

    /**
     * 标题名
     */
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        initTablayout();
        initDataBase();

    }

    private void initDataBase() {
        DatabaseHelper dbhelper =new DatabaseHelper(this,DatabaseHelper.NOTEBOOK,null,1);
        dbhelper.getWritableDatabase();
    }

    @OnClick(R.id.profile_image)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.profile_image:
                contentView.openDrawer(Gravity.START);
                break;
                default:
                    break;
        }
    }


    private void initView() {
        fragments.add(new MainFragment());
        fragments.add(new PublicNumFragment());
        fragments.add(new ClassificationFragment());
        mList.add("首页");
        mList.add("公众号");
        mList.add("体系");

    }

    private void initTablayout() {

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }


            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mList.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Subscribe
    public void onEvent(BitmapEvent bitmapEvent) {
        profileimage.setImageBitmap(bitmapEvent.getBitmap());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
