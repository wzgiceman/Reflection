package com.wzgiceman.reflection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wzgiceman.reflectionutils.ReflectUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_msg)
    TextView mTvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    User user;

    /*反射初始化对象*/
    @OnClick(value = R.id.btn_craete)
    void onBtnCraeteClick(View view) {
        user = ReflectUtils.on(User.class).create("wzg").get();
        mTvMsg.setText(user.getMsg());
    }

    /*反射方法*/
    @OnClick(value = R.id.btn_get)
    void onBtnGetClick(View view) {
        if(user==null){
            Toast.makeText(this,"先初始化对象",Toast.LENGTH_SHORT).show();
            return;
        }
        String msg = ReflectUtils.on(user).call("setName","wzg_call").call("getName").get();
        mTvMsg.setText(msg);
    }

    /*反射属性*/
    @OnClick(value = R.id.btn_set)
    void onBtnSetClick(View view) {
        if(user==null){
            Toast.makeText(this,"先初始化对象",Toast.LENGTH_SHORT).show();
            return;
        }
        /*先设置在获取*/
        String msg = ReflectUtils.on(user).set("name", "wzg_set").field("name").get();
        mTvMsg.setText(msg);
    }

}
