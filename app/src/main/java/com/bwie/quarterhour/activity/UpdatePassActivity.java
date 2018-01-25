package com.bwie.quarterhour.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.MainActivity;
import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.UpdatePassBean;
import com.bwie.quarterhour.presenter.UpdatePassPresenter;
import com.bwie.quarterhour.view.UpdatePassView;
import com.facebook.drawee.view.SimpleDraweeView;

public class UpdatePassActivity extends BaseActivity implements UpdatePassView {

    private ImageView mBack;
    private TextView mHasUser;
    private SimpleDraweeView mLogo;
    private EditText mUser;
    private EditText mPass;
    private Button mComplete;
    private TextView mNotLogin;
    private UpdatePassPresenter updatePassPresenter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String pass;

    @Override
    protected void initData() {
        mLogo.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500977101);
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = preferences.edit();
        updatePassPresenter = new UpdatePassPresenter(this);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.update_back);
        mHasUser = (TextView) findViewById(R.id.hasUser);
        mLogo = (SimpleDraweeView) findViewById(R.id.update_logo);
        mUser = (EditText) findViewById(R.id.update_user);
        mPass = (EditText) findViewById(R.id.update_pass);
        mComplete = (Button) findViewById(R.id.update_complete);
        mNotLogin = (TextView) findViewById(R.id.notLogin);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_pass;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mHasUser.setOnClickListener(this);
        mComplete.setOnClickListener(this);
        mNotLogin.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.update_back:
                finish();
                break;
            case R.id.hasUser:
                $startActivity(Login2Activity.class);
                break;

            case R.id.update_complete:
                String user = mUser.getText().toString();
                pass = mPass.getText().toString();
                String uid = preferences.getString("uid", "");
                String password = preferences.getString("password", "");
                updatePassPresenter.updatePass(uid, password, user, pass);
                break;

            case R.id.notLogin:
                $startActivity(MainActivity.class);
                break;
        }
    }

    @Override
    public void isEmpty() {
        $Toast("密码不能为空");
    }

    @Override
    public void isEqual() {
        $Toast("两次输入密码不一致，请重新输入");
    }

    @Override
    public void isLength() {
        $Toast("密码长度不能小于6位");
    }

    @Override
    public void updateSuccess(UpdatePassBean updatePassBean) {
        if (updatePassBean.getCode().equals("0")) {
            $Toast("修改密码成功");
            editor.remove("password").commit();
            editor.putString("password", pass).commit();
            $startActivity(Login2Activity.class);
        } else {
            $Toast(updatePassBean.getMsg());
        }
    }

    @Override
    public void updateFailed(Throwable e) {
        $Toast("修改密码失败");
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (updatePassPresenter != null) {
            updatePassPresenter.detach();
        }
    }
}
