package com.bwie.quarterhour.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.R;

public class SuccessActivity extends BaseActivity {

    private ImageView mWeChat;
    private ImageView mSpace;
    private ImageView mQQ;
    private ImageView mFriends;
    private Button mGoto;
    private TextView mContent;

    @Override
    protected void initData() {
        Bundle bundle = $getIntentExtra();
        String content = bundle.getString("content");
        if (content.equals("1")) {
            mContent.setText("段子发布成功，快去要求小伙伴们围观吧！");
        } else {
            mContent.setText("视频发布成功，快去要求小伙伴们围观吧！");
        }
    }

    @Override
    protected void initView() {
        mFriends = (ImageView) findViewById(R.id.share_friends);
        mQQ = (ImageView) findViewById(R.id.share_qq);
        mSpace = (ImageView) findViewById(R.id.share_space);
        mWeChat = (ImageView) findViewById(R.id.share_weChat);
        mGoto = (Button) findViewById(R.id.goTo);
        mContent = (TextView) findViewById(R.id.content);
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
