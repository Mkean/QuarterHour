package com.bwie.quarterhour.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.quarterhour.R;

/*
*
* 相机
* */
public class CreationActivity extends BaseActivity {

    private LinearLayout mVideo;
    private TextView mRight;
    private TextView mTitle;
    private LinearLayout mLeft;
    private LinearLayout mJokes;
    private TextView mContent;
    private ImageView mImg;

    @Override
    protected void initData() {
        mRight.setVisibility(View.GONE);
        mImg.setVisibility(View.GONE);
        mContent.setText("取消");
    }

    @Override
    protected void initView() {
        mVideo = (LinearLayout) findViewById(R.id.create_video);
        mJokes = (LinearLayout) findViewById(R.id.create_jokes);
        mLeft = (LinearLayout) findViewById(R.id.text_left);
        mTitle = (TextView) findViewById(R.id.text_title);
        mRight = (TextView) findViewById(R.id.text_right);
        mContent = (TextView) findViewById(R.id.left_content);
        mImg = (ImageView) findViewById(R.id.left_img);
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
