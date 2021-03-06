package com.example.administrator.bin;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bin.activity.BaseActivity;
import com.example.administrator.bin.fragment.HomeFragment;
import com.example.administrator.bin.fragment.MineFragment;
import com.example.administrator.bin.fragment.RobotFragment;
import com.example.administrator.bin.fragment.WechatFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {


    private FragmentManager fm;
    private WechatFragment mHomeFragment;
    private Fragment mCommonFragmentOne;
    private HomeFragment mWechatFragment;
    private MineFragment mMineFragment;
    private RobotFragment mRobotFragment;
    private Fragment mCurrent;


    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    private long mExitTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();

        //默认要显示的页面
        mHomeFragment=new WechatFragment();
        fm=getFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,mHomeFragment);
        fragmentTransaction.commit();
    }


    private void initView() {

        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void hideFragment(Fragment fragment,FragmentTransaction ft){
        if(fragment!=null){
            ft.hide(fragment);
        }
    }
    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mWechatFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                hideFragment(mRobotFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new WechatFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    mCurrent = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                hideFragment(mRobotFragment, fragmentTransaction);
                if (mWechatFragment == null) {
                    mWechatFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mWechatFragment);
                } else {
                    mCurrent = mWechatFragment;
                    fragmentTransaction.show(mWechatFragment);
                }
                break;
            case R.id.mine_layout_view:
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mWechatFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mRobotFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    mCurrent = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }
                break;
            case R.id.pond_layout_view:
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond_selected);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mWechatFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mRobotFragment == null) {
                    mRobotFragment = new RobotFragment();
                    fragmentTransaction.add(R.id.content_layout, mRobotFragment);
                } else {
                    mCurrent = mRobotFragment;
                    fragmentTransaction.show(mRobotFragment);
                }
                break;

        }
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}