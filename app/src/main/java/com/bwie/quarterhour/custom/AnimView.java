package com.bwie.quarterhour.custom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者：王庆
 * 时间：2018/1/24
 */

public class AnimView extends RelativeLayout implements View.OnClickListener {

    private SimpleDraweeView mAdd;
    private SimpleDraweeView mLink;
    private SimpleDraweeView mReport;
    private SimpleDraweeView mShielding;
    private boolean isOpen = false;

    public AnimView(Context context) {
        super(context);
    }

    public AnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.anim_layout, this);
        mAdd = view.findViewById(R.id.add_simple);
        mLink = view.findViewById(R.id.link_simple);
        mReport =  view.findViewById(R.id.report_simple);
        mShielding = view.findViewById(R.id.shielding_simple);
        initData();
        setListener();
    }

    private void setListener() {
        mAdd.setOnClickListener(this);
        mLink.setOnClickListener(this);
        mReport.setOnClickListener(this);
        mShielding.setOnClickListener(this);
    }

    private void initData() {
        mAdd.setImageURI("res://com.bwie.quarterhour/" + R.drawable.add_icon);
        mLink.setImageURI(Uri.parse("res://com.bwie.quarterhour/" + R.drawable.link_icon));
        mReport.setImageURI(Uri.parse("res://com.bwie.quarterhour/" + R.drawable.report_icon));
        mShielding.setImageURI(Uri.parse("res://com.bwie.quarterhour/" + R.drawable.shielding_icon));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_simple:
//                Toast.makeText(getContext(), "加号", Toast.LENGTH_SHORT).show();
                initAnim();
                break;
            case R.id.report_simple:
                Toast.makeText(getContext(), "举报", Toast.LENGTH_SHORT).show();
                break;
            case R.id.link_simple:
                Toast.makeText(getContext(), "链接", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shielding_simple:
                Toast.makeText(getContext(), "屏蔽", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void initAnim() {
        if (!isOpen) {
            mAdd.setImageURI(Uri.parse("res://com.bwie.quarterhour/" + R.drawable.minus_icon));
            isOpen = true;
            unVisible();
            startAnim();
        } else {
            endAnim();
            mAdd.setImageURI(Uri.parse("res://com.bwie.quarterhour/" + R.drawable.add_icon));
            isOpen = false;
//            isVisible();
        }
    }

    private void endAnim() {
        //旋转
        ObjectAnimator rotate = new ObjectAnimator().ofFloat(mAdd, "rotation", 0f, 360f).setDuration(1000);
        //位移
        ObjectAnimator mReportTranX = new ObjectAnimator().ofFloat(mReport, "translationX", -60f, 0f).setDuration(1000);
        //旋转
        ObjectAnimator mReportRotate = new ObjectAnimator().ofFloat(mReport, "rotation", 0f, 360f).setDuration(1000);
        //透明
        ObjectAnimator mReportAlpha = new ObjectAnimator().ofFloat(mReport, "alpha", 1f, 0f).setDuration(1000);

        //位移
        ObjectAnimator mLinkTranX = new ObjectAnimator().ofFloat(mLink, "translationX", -120f, 0f).setDuration(1000);
        //旋转
        ObjectAnimator mLinkRotate = new ObjectAnimator().ofFloat(mLink, "rotation", 0f, 360f).setDuration(1000);
        //透明
        ObjectAnimator mLinkAlpha = new ObjectAnimator().ofFloat(mLink, "alpha", 1f, 0f).setDuration(1000);


        //位移
        ObjectAnimator mShieldingTranX = new ObjectAnimator().ofFloat(mShielding, "translationX", -180f, 0f).setDuration(1000);
        //旋转
        ObjectAnimator mShieldingRotate = new ObjectAnimator().ofFloat(mShielding, "rotation", 0f, 360f).setDuration(1000);
        //透明
        ObjectAnimator mShieldingAlpha = new ObjectAnimator().ofFloat(mShielding, "alpha", 1f, 0f).setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.play(rotate).with(mReportTranX).with(mReportRotate).with(mReportAlpha)
                .with(mLinkTranX).with(mLinkRotate).with(mLinkAlpha)
                .with(mShieldingTranX).with(mShieldingRotate).with(mShieldingAlpha);
        set.start();
    }

    private void startAnim() {
        //旋转
        ObjectAnimator rotate = new ObjectAnimator().ofFloat(mAdd, "rotation", 360f, 0f).setDuration(1000);



        //位移
        ObjectAnimator mReportTranX = new ObjectAnimator().ofFloat(mReport, "translationX", 0f, -60f).setDuration(1000);
        //旋转
        ObjectAnimator mReportRotate = new ObjectAnimator().ofFloat(mReport, "rotation", 360f, 0f).setDuration(1000);
        //透明
        ObjectAnimator mReportAlpha = new ObjectAnimator().ofFloat(mReport, "alpha", 0f, 1f).setDuration(1000);

        //位移
        ObjectAnimator mLinkTranX = new ObjectAnimator().ofFloat(mLink, "translationX", 0f, -120f).setDuration(1000);
        //旋转
        ObjectAnimator mLinkRotate = new ObjectAnimator().ofFloat(mLink, "rotation", 360f, 0f).setDuration(1000);
        //透明
        ObjectAnimator mLinkAlpha = new ObjectAnimator().ofFloat(mLink, "alpha", 0f, 1f).setDuration(1000);


        //位移
        ObjectAnimator mShieldingTranX = new ObjectAnimator().ofFloat(mShielding, "translationX", 0f, -180f).setDuration(1000);
        //旋转
        ObjectAnimator mShieldingRotate = new ObjectAnimator().ofFloat(mShielding, "rotation", 360f, 0f).setDuration(1000);
        //透明
        ObjectAnimator mShieldingAlpha = new ObjectAnimator().ofFloat(mShielding, "alpha", 0f, 1f).setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.play(rotate).with(mReportTranX).with(mReportRotate).with(mReportAlpha)
                .with(mLinkTranX).with(mLinkRotate).with(mLinkAlpha)
                .with(mShieldingTranX).with(mShieldingRotate).with(mShieldingAlpha);
        set.start();
    }

    private void unVisible() {
        mReport.setVisibility(VISIBLE);
        mLink.setVisibility(VISIBLE);
        mShielding.setVisibility(VISIBLE);
    }

}
