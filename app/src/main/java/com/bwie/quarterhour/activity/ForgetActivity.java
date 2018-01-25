package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.MainActivity;
import com.bwie.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ForgetActivity extends BaseActivity {

    private ImageView mBack;
    private SimpleDraweeView mLogo;
    private EditText mUser;
    private TextView mGetCode;
    private EditText mPass;
    private Button mDoNext;
    private TextView mNotLogin;
    private TextView mHasUser;

    @Override
    protected void initData() {
        mLogo.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500977101);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.forget_back);
        mHasUser = (TextView) findViewById(R.id.hasUser);
        mLogo = (SimpleDraweeView) findViewById(R.id.forget_logo);
        mUser = (EditText) findViewById(R.id.forget_user);
        mGetCode = (TextView) findViewById(R.id.getCode);
        mPass = (EditText) findViewById(R.id.code);
        mDoNext = (Button) findViewById(R.id.doNext);
        mNotLogin = (TextView) findViewById(R.id.notLogin);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mGetCode.setOnClickListener(this);
        mHasUser.setOnClickListener(this);
        mNotLogin.setOnClickListener(this);
        mDoNext.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.forget_back:
                finish();
                break;
            case R.id.hasUser:
                finish();
                break;

            case R.id.getCode:
                $Toast("小程正在努力开发中…");
                break;

            case R.id.doNext:
                $startActivity(UpdatePassActivity.class);
                overridePendingTransition(R.anim.activity_in_anim, R.anim.activity_out_anim);
                break;

            case R.id.notLogin:
                $startActivity(MainActivity.class);
                break;

        }
    }
}
