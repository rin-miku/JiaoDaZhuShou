package com.shinemirai.jiaodazhushou.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initData();

    public void showToast(String message)//Toast提示函数
    {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }


    public void showToastSync(String message)//异步消息提醒
    {
        Looper.prepare();
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls)//页面跳转函数
    {
        Intent in = new Intent(mContext,cls);
        startActivity(in);
    }
}
