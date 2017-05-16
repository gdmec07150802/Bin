package com.example.administrator.bin.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.bin.R;
import com.example.administrator.bin.activity.BaseActivity;
import com.example.administrator.bin.utils.UtilTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
public class AboutActivity extends BaseActivity {

    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private ArrayAdapter<String>mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //去除阴影
        getSupportActionBar().setElevation(0);

        initView();
    }

    //初始化View
    private void initView() {
        mListView = (ListView) findViewById(R.id.mListView);

        mList.add(getString(R.string.text_app_name) + getString(R.string.app_name));
        mList.add(getString(R.string.text_version) + UtilTools.getVersion(this));
        mList.add(getString(R.string.text_website_address));

        //this是上下文
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        //设置适配器
        mListView.setAdapter(mAdapter);
    }
}

