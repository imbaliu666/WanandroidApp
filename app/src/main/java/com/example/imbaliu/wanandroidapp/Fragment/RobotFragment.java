package com.example.imbaliu.wanandroidapp.Fragment;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.imbaliu.wanandroidapp.Adapter.RobotAdapter;
import com.example.imbaliu.wanandroidapp.BaseSubscriber;
import com.example.imbaliu.wanandroidapp.Bean.Robot.InputText;
import com.example.imbaliu.wanandroidapp.Bean.Robot.Perception;
import com.example.imbaliu.wanandroidapp.Bean.Robot.Results;
import com.example.imbaliu.wanandroidapp.Bean.Robot.RobotRequest;
import com.example.imbaliu.wanandroidapp.Bean.Robot.RobotResponse;
import com.example.imbaliu.wanandroidapp.Bean.Robot.UserInfo;
import com.example.imbaliu.wanandroidapp.Httpserver.HttpUtils;
import com.example.imbaliu.wanandroidapp.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Fragment
 * 文件名： RobotFragment
 * 创建者： LFY
 * 创建时间： 2019/2/19 14:48
 * 描述：   TODO
 */

public class RobotFragment extends BaseFragment {

    private String inputInfo;
    private RobotAdapter adapter;

    @BindView(R.id.edit_text)
    EditText edit_text;

    @BindView(R.id.button)
    Button button;


    @BindView(R.id.robot_recyclerview)
    RecyclerView robot_recyclerview;
    @Override
    public int onGetLayout() {
        return R.layout.fragment_robot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         adapter =new RobotAdapter(R.layout.item_robot_right,null);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        robot_recyclerview.setLayoutManager(layoutManager);
        robot_recyclerview.setAdapter(adapter);
    }
    @OnClick(R.id.button)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                inputInfo=edit_text.getText().toString().trim();
                edit_text.setText("");
                adapter.addData(inputInfo);
                robot_recyclerview.smoothScrollToPosition(adapter.getItemCount()-1);
                queryRobot();
                break;
                default:
                    break;
        }


    }

    private void queryRobot() {
        RobotRequest request =new RobotRequest();
        Perception perception =new Perception();
        InputText inputText =new InputText(inputInfo);
        perception.setInputText(inputText);
        request.setPerception(perception);
        UserInfo userInfo =new UserInfo("8ccf27a39459485fb6c595d05fea21f6","199053");
        request.setUserInfo(userInfo);
        HttpUtils.requestRobot(request, new BaseSubscriber<RobotResponse>() {
            @Override
            public void onDoNext(RobotResponse robotResponse) {
                if (robotResponse.getResults() !=null) {
                    for (Results results :robotResponse.getResults()) {
                        if ("text".equals(results.getResultType())) {
                            adapter.addData(results.getValues().getText());
                            robot_recyclerview.smoothScrollToPosition(adapter.getItemCount()-1);

                        }
                    }
                }
            }
        });
    }
}
