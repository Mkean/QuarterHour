package com.bwie.quarterhour.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoginActivity extends BaseActivity {

    private SimpleDraweeView mLogo;
    private ImageView mBack;
    private TextView mBt;

    @Override
    protected void initData() {
        mLogo.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500977101);
    }

    @Override
    protected void initView() {
        mLogo = (SimpleDraweeView) findViewById(R.id.login_logo);
        mBack = (ImageView) findViewById(R.id.login_back);
        mBt = (TextView) findViewById(R.id.login_bt);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mBt.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.login_bt:
                Intent intent = new Intent(this, Login2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_anim, R.anim.activity_out_anim);
                break;

        }
    }
}
