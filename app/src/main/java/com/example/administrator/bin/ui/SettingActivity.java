package com.example.administrator.bin.ui;

/*
 *    设置
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.administrator.bin.R;
import com.example.administrator.bin.activity.BaseActivity;
import com.example.administrator.bin.utils.ShareUtils;


public class SettingActivity extends BaseActivity implements View.OnClickListener {

    //语音播报
    private Switch sw_speak;
    //关于软件
    private LinearLayout ll_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
    }

    //初始化View
    private void initView() {

        sw_speak = (Switch) findViewById(R.id.sw_speak);
        sw_speak.setOnClickListener(this);
        boolean isSpeak= ShareUtils.getBoolean(this, "isSpeak", false);
        sw_speak.setChecked(isSpeak);
        ll_about = (LinearLayout) findViewById(R.id.ll_about);
        ll_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sw_speak:
                //切换相反
                sw_speak.setSelected(!sw_speak.isSelected());
                //保存状态
                ShareUtils.putBoolean(this, "isSpeak", sw_speak.isChecked());
                break;

            case R.id.ll_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;
        }
    }


}
