package com.example.administrator.bin.application;

import android.app.Application;


import com.baidu.mapapi.SDKInitializer;
import com.example.administrator.bin.utils.StaticClass;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import cn.bmob.v3.Bmob;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化BMob
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
        // 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID + "=" + StaticClass.VOICE_KEY);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }
}
