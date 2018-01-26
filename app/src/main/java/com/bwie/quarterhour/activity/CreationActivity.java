package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.quarterhour.R;

public class CreationActivity extends BaseActivity {

    private LinearLayout mVideo;
    private TextView mRight;
    private TextView mTitle;
    private TextView mLeft;
    private LinearLayout mJokes;

    @Override
    protected void initData() {
        mRight.setVisibility(View.GONE);
    }

    @Override
    protected void initView() {
        mVideo = (LinearLayout) findViewById(R.id.create_video);
        mJokes = (LinearLayout) findViewById(R.id.create_jokes);
        mLeft = (TextView) findViewById(R.id.text_left);
        mTitle = (TextView) findViewById(R.id.text_title);
        mRight = (TextView) findViewById(R.id.text_right);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_creation;
    }

    @Override
    protected void setListener() {
        mVideo.setOnClickListener(this);
        mJokes.setOnClickListener(this);
        mLeft.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.create_video:
                $startActivity(VideoActivity.class);
                break;
            case R.id.create_jokes:
                $startActivity(JokesActivity.class);
                finish();
                break;

            case R.id.text_left:
                finish();
                break;

        }
    }
}
