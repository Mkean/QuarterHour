package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.MainActivity;
import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.RegisterBean;
import com.bwie.quarterhour.presenter.RegisterPresenter;
import com.bwie.quarterhour.view.RegisterView;
import com.facebook.drawee.view.SimpleDraweeView;

public class RegisterActivity extends BaseActivity implements RegisterView {


    private SimpleDraweeView mLogo;
    private ImageView mBack;
    private TextView mHasUser;
    private EditText mUser;
    private EditText mPass;
    private Button mRegister;
    private TextView mNotLogin;
    private RegisterPresenter registerPresenter;

    @Override
    protected void initData() {
        mLogo.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500977101);
        registerPresenter = new RegisterPresenter(this);

    }


    @Override
    protected void initView() {
        mLogo = (SimpleDraweeView) findViewById(R.id.reg_logo);
        mBack = (ImageView) findViewById(R.id.reg_back);
        mHasUser = (TextView) findViewById(R.id.hasUser);
        mUser = (EditText) findViewById(R.id.reg_user);
        mPass = (EditText) findViewById(R.id.reg_pass);
        mRegister = (Button) findViewById(R.id.register);
        mNotLogin = (TextView) findViewById(R.id.notLogin);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mNotLogin.setOnClickListener(this);
        mHasUser.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.reg_back:
                finish();
                break;
            //跳转注册界面
            case R.id.hasUser:
                finish();
                break;
            //登录
            case R.id.register:
                String user = mUser.getText().toString();
                String pass = mPass.getText().toString();
                registerPresenter.register(user, pass);
                break;
            //游客登录
            case R.id.notLogin:
                $startActivity(MainActivity.class);
                break;
        }
    }

    @Override
    public void isEmpty() {
        $Toast("账号或密码不能为空");
    }

    @Override
    public void passLength() {
        $Toast("密码长度不能小于6位");
    }

    @Override
    public void registerSuccess(RegisterBean registerBean) {
        if (registerBean.getCode().equals("0")) {
            $Toast("注册成功");

            finish();
        } else {
            $Toast("账号或密码输入有误");
        }
    }

    @Override
    public void registerFailed(Throwable e) {
        $Toast("注册失败");
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (registerPresenter != null) {
            registerPresenter.detach();
        }
    }
}
