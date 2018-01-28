package com.bwie.quarterhour.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.quarterhour.R;
import com.bwie.quarterhour.adapter.MyMessageAdapter;
import com.bwie.quarterhour.bean.CommentBean;
import com.bwie.quarterhour.bean.PraiseBean;
import com.bwie.quarterhour.bean.VideoDetailsBean;
import com.bwie.quarterhour.presenter.CommentPresenter;
import com.bwie.quarterhour.presenter.PraisePresenter;
import com.bwie.quarterhour.presenter.VideoDetailsPresenter;
import com.bwie.quarterhour.view.CommentView;
import com.bwie.quarterhour.view.PraiseView;
import com.bwie.quarterhour.view.VideoDetailsView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class DetailsActivity extends BaseActivity implements CommentView, VideoDetailsView, PraiseView {


    private RecyclerView mLv;
    private Button mRelease;
    private TextView mEditText;
    private TextView mLeave;
    private LinearLayout mLinear;
    private TextView mPlayNum;
    private JCVideoPlayerStandard mVideo;
    private SimpleDraweeView mHead;
    private ImageView mShare;
    private CheckBox mHate;
    private CheckBox mLike;
    private ImageView mBack;
    private LinearLayout mEdit;
    private MyMessageAdapter adapter;
    private CommentPresenter commentPresenter;
    private SharedPreferences preferences;
    private String uid;
    private String token;
    private VideoDetailsPresenter videoDetailsPresenter;
    private String wid;
    private VideoDetailsBean.DataBean data;
    private PraisePresenter praisePresenter;
    private PopupWindow mPopupWindow;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        wid = intent.getStringExtra("wid");
        getPresenter();
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        uid = preferences.getString("uid", "");
        token = preferences.getString("token", "");
        if (uid.equals("") || token.equals("")) {
            $Toast("请先登录");
            $startActivity(Login2Activity.class);
            return;
        }

    }

    private void getPresenter() {
        commentPresenter = new CommentPresenter(this);
        videoDetailsPresenter = new VideoDetailsPresenter(this);
        videoDetailsPresenter.getVideoDetails(wid);
        praisePresenter = new PraisePresenter(this);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.details_back);
        mLike = (CheckBox) findViewById(R.id.details_like);
        mHate = (CheckBox) findViewById(R.id.details_hate);
        mShare = (ImageView) findViewById(R.id.details_share);
        mHead = (SimpleDraweeView) findViewById(R.id.details_head);
        mVideo = (JCVideoPlayerStandard) findViewById(R.id.details_video);
        mPlayNum = (TextView) findViewById(R.id.details_playNum);
        mLv = (RecyclerView) findViewById(R.id.details_lv);
        mLinear = (LinearLayout) findViewById(R.id.details_linear);
        mEdit = (LinearLayout) findViewById(R.id.details_edit);
        mLeave = (TextView) findViewById(R.id.details_leave);
        mEditText = (TextView) findViewById(R.id.editText);
        mRelease = (Button) findViewById(R.id.details_release);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mLike.setOnClickListener(this);
        mHate.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mHead.setOnClickListener(this);
        mLeave.setOnClickListener(this);
        mRelease.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.details_back:
                finish();
                break;
            case R.id.details_like:
                if (mHate.isChecked()) {
                    mLike.setChecked(false);
                } else if (mLike.isChecked()) {
                    praisePresenter.praise(uid, wid, token);
                }
                $Log(mLike.isChecked() + "====" + mHate.isChecked());
                break;
            case R.id.details_hate:
                if (mLike.isChecked()) {
                    mHate.setChecked(false);
                }
                $Log(mHate.isChecked() + "====" + mLike.isChecked());
                break;
            case R.id.details_share:
                setShare();
                break;
            case R.id.details_head:
                Bundle bundle = new Bundle();
                bundle.putString("uid", data.getUid());
                $startActivity(UserActivity.class, bundle);
                break;
            case R.id.details_leave:
                mEdit.setVisibility(View.VISIBLE);
                break;
            case R.id.details_release:
                String s = mEditText.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(this, "请填写内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                commentPresenter.comment(uid, wid, s, token);
                break;
            case R.id.share_cancel:
                mPopupWindow.dismiss();
                break;
            case R.id.share_space:
                break;
            case R.id.share_weChat:
                break;
            case R.id.share_qq:
                break;
            case R.id.share_friends:
                break;


        }
    }

    private void setShare() {
        View view = LayoutInflater.from(this).inflate(R.layout.share_popu, null);
        mPopupWindow = new PopupWindow(view, ViewGroup.MarginLayoutParams.MATCH_PARENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        ImageView mSpace = view.findViewById(R.id.share_space);
        ImageView mWeChat = view.findViewById(R.id.share_weChat);
        TextView mCancel = view.findViewById(R.id.share_cancel);
        ImageView mQQ = view.findViewById(R.id.share_qq);
        ImageView mFriends = view.findViewById(R.id.share_friends);
        mSpace.setOnClickListener(this);
        mWeChat.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mFriends.setOnClickListener(this);
    }

    @Override
    public void getVideoDetailsSuccess(VideoDetailsBean videoDetailsBean) {
        if (videoDetailsBean.getCode().equals("0")) {
            data = videoDetailsBean.getData();
            List<VideoDetailsBean.DataBean.CommentsBean> comments = data.getComments();
            if (data.getCommentNum().equals("0")) {
                mLinear.setVisibility(View.VISIBLE);
                mLv.setVisibility(View.GONE);
                mEdit.setVisibility(View.GONE);
            } else {
                mLinear.setVisibility(View.GONE);
                mLv.setVisibility(View.VISIBLE);
                mEdit.setVisibility(View.VISIBLE);
            }

            adapter = new MyMessageAdapter(comments, this);
            mLv.setLayoutManager(new LinearLayoutManager(this));
            mLv.setAdapter(adapter);
            mVideo.setUp("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "李少奇骑猪上高速");
//        ImageView ivThumb = holder.mJcPlayer.ivThumb;
            Glide.with(this).load(R.drawable.raw_1500978299)
                    .into(mVideo.thumbImageView);

        } else {
            $Toast(videoDetailsBean.getMsg());
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void getVideoDetailsFailed(Throwable e) {
        $Toast("失败");
        $Log(e.getMessage().toString());
    }


    @Override
    public void commentSuccess(CommentBean commentBean) {
        if (commentBean.getCode().equals("0")) {
            $Toast("评论成功");
            videoDetailsPresenter.getVideoDetails(wid);
        } else {
            $Toast(commentBean.getMsg());
        }
    }

    @Override
    public void commentFailed(Throwable e) {
        $Toast("失败");
        $Log(e.getMessage().toString());
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (commentPresenter != null) {
            commentPresenter.detach();
        }
        if (videoDetailsPresenter != null) {
            videoDetailsPresenter.detach();
        }
        if (praisePresenter != null) {
            praisePresenter.detach();
        }
    }


    @Override
    public void praiseSuccess(PraiseBean praiseBean) {
        if (!praiseBean.getCode().equals("0")) {
            $Toast(praiseBean.getMsg());
        }
    }

    @Override
    public void praiseFailed(Throwable e) {
        $Toast("失败");
        $Log(e.getMessage().toString());
    }
}
