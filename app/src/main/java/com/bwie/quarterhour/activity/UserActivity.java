package com.bwie.quarterhour.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.FollowBean;
import com.bwie.quarterhour.presenter.FollowPresenter;
import com.bwie.quarterhour.view.FollowView;
import com.facebook.drawee.view.SimpleDraweeView;

import static com.bwie.quarterhour.R.id.follow_bt;

/*
*    获取某个用户的视频作品集
*   头像放大
* */
public class UserActivity extends BaseActivity implements FollowView {

    private String followId;
    private SimpleDraweeView mHead;
    private RecyclerView mLv;
    private TextView mPraiseNum;
    private LinearLayout mPraiseBt;
    private Button mBt;
    private TextView mFollowNum;
    private TextView mName;
    private ImageView mPraiseImg;
    private ImageView mMessage;
    private ImageView mShare;
    private ImageView mBack;
    private FollowPresenter followPresenter;
    private SharedPreferences preferences;
    private int num = 16;
    private int praise = 16;
    private int i = 0;
    private String token;
    private String uid;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        followId = intent.getStringExtra("uid");
        mHead.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500002478);
        followPresenter = new FollowPresenter(this);
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        uid = preferences.getString("uid", "");
        token = preferences.getString("token", "");
        if (uid.equals("") || token.equals("")) {
            $Toast("请先登录");
            $startActivity(Login2Activity.class);
            return;
        }
    }

    @Override
    protected void initView() {
        mHead = (SimpleDraweeView) findViewById(R.id.head_simple);
        mBack = (ImageView) findViewById(R.id.user_back);
        mShare = (ImageView) findViewById(R.id.user_share);
        mMessage = (ImageView) findViewById(R.id.user_message);
        mPraiseImg = (ImageView) findViewById(R.id.praise_img);
        mName = (TextView) findViewById(R.id.user_name);
        mFollowNum = (TextView) findViewById(R.id.follow_num);
        mBt = (Button) findViewById(R.id.follow_bt);
        mPraiseBt = (LinearLayout) findViewById(R.id.praise_bt);
        mPraiseNum = (TextView) findViewById(R.id.praise_num);
        mLv = (RecyclerView) findViewById(R.id.user_lv);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void setListener() {
        mHead.setOnClickListener(this);
        mPraiseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    mPraiseBt.setBackground(getResources().getDrawable(R.drawable.one_praise));
                    praise++;
                    mPraiseNum.setText(praise + "");
                    i = 1;
                } else if (i == 1) {
                    mPraiseBt.setBackground(getResources().getDrawable(R.drawable.two_praise));
                    praise++;
                    mPraiseNum.setText(praise + "");
                    i = 2;
                } else if (i == 2) {
                    mPraiseBt.setBackground(getResources().getDrawable(R.drawable.three_praise));
                    praise++;
                    mPraiseNum.setText(praise + "");
                    i = 3;
                } else {
                    $Toast("每个用户只可以赞三次");
                }
            }
        });
        mBt.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mMessage.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.head_simple:
                $Toast("小程正在努力研发中…");
                break;
            case follow_bt:
                followPresenter.follow(uid, followId, token);
                break;
            case R.id.user_share:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.user_message:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.user_back:
                finish();
                break;
        }
    }

    @Override
    public void followSuccess(FollowBean followBean) {
        if (followBean.getCode().equals("0")) {
            $Toast("关注成功");
            mBt.setText("已关注");
            mBt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            num++;
            mFollowNum.setText(num + "人关注");
        } else {
            $Toast(followBean.getMsg());
        }
    }

    @Override
    public void followFailed(Throwable e) {
        Toast.makeText(this, "关注失败", Toast.LENGTH_SHORT).show();
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (followPresenter != null) {
            followPresenter.detach();
        }
    }
}
