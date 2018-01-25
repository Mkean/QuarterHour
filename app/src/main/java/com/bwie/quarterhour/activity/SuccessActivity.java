package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwie.quarterhour.R;

public class SuccessActivity extends BaseActivity {

    private ImageView mWeChat;
    private ImageView mSpace;
    private ImageView mQQ;
    private ImageView mFriends;
    private Button mGoto;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mFriends = (ImageView) findViewById(R.id.share_friends);
        mQQ = (ImageView) findViewById(R.id.share_qq);
        mSpace = (ImageView) findViewById(R.id.share_space);
        mWeChat = (ImageView) findViewById(R.id.share_weChat);
        mGoto = (Button) findViewById(R.id.goTo);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_success;
    }

    @Override
    protected void setListener() {
        mFriends.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mSpace.setOnClickListener(this);
        mWeChat.setOnClickListener(this);
        mGoto.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.share_friends:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.share_qq:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.share_space:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.share_weChat:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.goTo:
                $startActivity(DetailsActivity.class);
                break;

        }
    }
}
