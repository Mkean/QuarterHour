package com.bwie.quarterhour.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.JokeBean;
import com.bwie.quarterhour.presenter.JokesPresenter;
import com.bwie.quarterhour.view.JokesView;

public class JokesActivity extends BaseActivity implements JokesView {


    private LinearLayout mLeft;
    private TextView mTitle;
    private TextView mRight;
    private ImageView mImg;
    private EditText mJokes;
    private SharedPreferences preferences;
    private JokesPresenter jokesPresenter;
    private PopupWindow mPopupWindow;
    private ImageView mLeftImg;
    private TextView mContent;
    private String uid;
    private String token;


    @Override
    protected void initData() {
        jokesPresenter = new JokesPresenter(this);
        mContent.setText("取消");
        mLeftImg.setVisibility(View.GONE);
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        uid = preferences.getString("uid", "");
        token = preferences.getString("token", "");
        if (uid.equals("") || token.equals("")) {
            $Toast("请先登录");
            $startActivity(Login2Activity.class);
            return;
        }
        mRight.setText("发表");
    }

    @Override
    protected void initView() {
        mJokes = (EditText) findViewById(R.id.ed_jokes);
        mImg = (ImageView) findViewById(R.id.ed_img);
        mLeftImg = (ImageView) findViewById(R.id.left_img);
        mLeft = (LinearLayout) findViewById(R.id.text_left);
        mTitle = (TextView) findViewById(R.id.text_title);
        mRight = (TextView) findViewById(R.id.text_right);
        mContent = (TextView) findViewById(R.id.left_content);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_jokes;
    }

    @Override
    protected void setListener() {
        mImg.setOnClickListener(this);
        mLeft.setOnClickListener(this);
        mRight.setOnClickListener(this);

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.ed_img:
                $Toast("小程正在努力研发中…");
                break;
            case R.id.text_right:
                String jokes = mJokes.getText().toString();
                jokesPresenter.releaseJokes(uid, jokes, token);
                break;

            case R.id.text_left:
                initPopupWindow();
                break;
            case R.id.pop_cancel:
                mPopupWindow.dismiss();
                break;
            case R.id.pop_keep:
                finish();
                break;
            case R.id.pop_unKeep:
                finish();
                break;
        }
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.pullupmenu_layout, null);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
//        ColorDrawable dw = new ColorDrawable(0xffffffff);
//        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);


        Button mKeep = view.findViewById(R.id.pop_keep);
        Button mUnKeep = view.findViewById(R.id.pop_unKeep);
        Button mCancel = view.findViewById(R.id.pop_cancel);
        mKeep.setOnClickListener(this);
        mUnKeep.setOnClickListener(this);
        mCancel.setOnClickListener(this);

    }

    @Override
    public void releaseSuccess(JokeBean jokeBean) {
        if (jokeBean.getCode().equals("0")) {
            $Toast("发布成功");
            Bundle bundle = new Bundle();
            bundle.putString("content", "1");
            $startActivity(SuccessActivity.class, bundle);
        } else {
            $Toast(jokeBean.getMsg());
        }
    }

    @Override
    public void releaseFailed(Throwable e) {
        $Toast("发布失败");
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (jokesPresenter != null) {
            jokesPresenter.detach();
        }
    }

}
