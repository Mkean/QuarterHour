package com.bwie.quarterhour.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.MainActivity;
import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.LoginBean;
import com.bwie.quarterhour.presenter.LoginPresenter;
import com.bwie.quarterhour.view.LoginView;
import com.facebook.drawee.view.SimpleDraweeView;

public class Login2Activity extends BaseActivity implements LoginView {

    private SimpleDraweeView mLogo;
    private ImageView mBack;
    private TextView mRegister;
    private EditText mUser;
    private EditText mPass;
    private Button mLogin;
    private TextView mForgetPass;
    private TextView mNotLogin;
    private LoginPresenter loginPresenter;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private String pass;

    @Override
    protected void initData() {
        getShared();
        mLogo.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500977101);
        loginPresenter = new LoginPresenter(this);
    }

    private void getShared() {
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    protected void initView() {
        mLogo = (SimpleDraweeView) findViewById(R.id.login2_logo);
        mBack = (ImageView) findViewById(R.id.login2_back);
        mRegister = (TextView) findViewById(R.id.login2_register);
        mUser = (EditText) findViewById(R.id.user);
        mPass = (EditText) findViewById(R.id.pass);
        mLogin = (Button) findViewById(R.id.login);
        mForgetPass = (TextView) findViewById(R.id.forget_pass);
        mNotLogin = (TextView) findViewById(R.id.notLogin);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login2;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mForgetPass.setOnClickListener(this);
        mNotLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.login2_back:
                finish();
                break;
            //跳转注册界面
            case R.id.login2_register:
                $startActivity(RegisterActivity.class);
                overridePendingTransition(R.anim.activity_in_anim, R.anim.activity_out_anim);
                break;
            //登录
            case R.id.login:
                String user = mUser.getText().toString();
                pass = mPass.getText().toString();
                loginPresenter.login(user, pass);
                break;
            //忘记密码
            case R.id.forget_pass:
                $startActivity(ForgetActivity.class);
                overridePendingTransition(R.anim.activity_in_anim, R.anim.activity_out_anim);
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
    public void loginSuccess(LoginBean loginBean) {
        if (loginBean.getCode().equals("0")) {
            $Toast("登录成功");
            if (!pass.equals(preferences.getString("password", "1"))) {
                editor.clear().commit();
            }
            editor.putString("uid", loginBean.getData().getUid());
            editor.putString("password", pass);
            editor.putString("token", loginBean.getData().getToken());
            editor.commit();
            $startActivity(MainActivity.class);
        } else {
            $Toast("账号或密码输入有误");
        }
    }

    @Override
    public void loginFailed(Throwable e) {
        $Toast("登录失败");
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginPresenter != null) {
            loginPresenter.detach();
        }
    }
}
