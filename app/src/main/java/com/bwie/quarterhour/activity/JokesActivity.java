package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.quarterhour.R;

public class JokesActivity extends BaseActivity {


    private TextView mLeft;
    private TextView mTitle;
    private TextView mRight;
    private ImageView mImg;
    private EditText mJokes;

    @Override
    protected void initData() {
        mRight.setText("发表");
    }

    @Override
    protected void initView() {
        mJokes = (EditText) findViewById(R.id.ed_jokes);
        mImg = (ImageView) findViewById(R.id.ed_img);
        mLeft = (TextView) findViewById(R.id.text_left);
        mTitle = (TextView) findViewById(R.id.text_title);
        mRight = (TextView) findViewById(R.id.text_right);
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
                break;

            case R.id.text_left:
                finish();
                break;
        }
    }
}
