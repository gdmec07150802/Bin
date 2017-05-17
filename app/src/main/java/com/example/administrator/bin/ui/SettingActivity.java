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
import com.example.administrator.bin.service.SmsService;
import com.example.administrator.bin.utils.ShareUtils;


public class SettingActivity extends BaseActivity implements View.OnClickListener {

    //语音播报
    private Switch sw_speak;
    //短信提醒
    private Switch sw_sms;
    //我的位置
    private LinearLayout ll_my_location;
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
        sw_sms = (Switch) findViewById(R.id.sw_sms);
        sw_sms.setOnClickListener(this);
        boolean isSms = ShareUtils.getBoolean(this, "isSms", false);
        sw_sms.setChecked(isSms);
        ll_my_location=(LinearLayout) findViewById(R.id.ll_my_location);
        ll_my_location.setOnClickListener(this);
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
            case R.id.sw_sms:
                //切换相反
                sw_sms.setSelected(!sw_sms.isSelected());
                //保存状态
                ShareUtils.putBoolean(this, "isSms", sw_sms.isChecked());
                if (sw_sms.isChecked()) {
                    startService(new Intent(this, SmsService.class));
                } else {
                    stopService(new Intent(this, SmsService.class));
                }
                break;

            case R.id.ll_my_location:
                startActivity(new Intent(this,LocationActivity.class));
                break;

            case R.id.ll_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;
        }
    }


}
