package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.quarterhour.R;
import com.bwie.quarterhour.activity.UserActivity;
import com.bwie.quarterhour.bean.VideosBean;
import com.bwie.quarterhour.custom.AnimView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

/*
* 视频点击事件，喜欢等的显示
*
* */

public class MyHotItemAdapter extends RecyclerView.Adapter<MyHotItemAdapter.MyItemHolder> {
    private List<VideosBean.DataBean> list;
    private Context context;
    private boolean isVisible = false;

    public MyHotItemAdapter(List<VideosBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_item, parent, false);
        MyItemHolder holder = new MyItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyItemHolder holder, int position) {
        final VideosBean.DataBean dataBean = list.get(position);
        VideosBean.DataBean.UserBean user = dataBean.getUser();
        if (user.getIcon() == null) {
            holder.mSimple.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500002478);
        } else {
            holder.mSimple.setImageURI(Uri.parse((String) user.getIcon()));
        }
        if (user.getNickname() == null) {
            holder.mName.setText("天蝎喝牛奶");
        } else {
            holder.mName.setText(user.getNickname() + "");
        }
        holder.mCreateTime.setText(dataBean.getCreateTime() + "");

        holder.mHotLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("uid", dataBean.getUid());
                context.startActivity(intent);
            }
        });
        holder.mJcPlayer.setUp(dataBean.getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "李少奇骑猪上高速");
//        ImageView ivThumb = holder.mJcPlayer.ivThumb;
        Glide.with(context).load(R.drawable.raw_1500978299)
                .into(holder.mJcPlayer.thumbImageView);

        //喜欢
        holder.mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mLinear.setVisibility(View.VISIBLE);
                isVisible = true;
                Toast.makeText(context, "asdds", Toast.LENGTH_SHORT).show();
            }
        });
        //收藏
        holder.mCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mLinear.setVisibility(View.VISIBLE);
                isVisible = true;
                Toast.makeText(context, "asdds", Toast.LENGTH_SHORT).show();
            }
        });
        //分享
        holder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mLinear.setVisibility(View.VISIBLE);
                isVisible = true;
                Toast.makeText(context, "asdds", Toast.LENGTH_SHORT).show();
            }
        });
        //留言
        holder.mPlayMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mLinear.setVisibility(View.VISIBLE);
                isVisible = true;
                Toast.makeText(context, "asdds", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyItemHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView mSimple;
        private final TextView mName;
        private final TextView mCreateTime;
        private final AnimView mAnim;
        private final TextView mTitle;
        //        private final SimpleDraweeView mPlayerSimpler;
//        private final SimpleDraweeView mSwitch;
        private final ImageView mLike;
        private final ImageView mCollection;
        private final ImageView mShare;
        private final ImageView mPlayMessage;
        private final TextView mUser;
        private final TextView mMessage;
        private final LinearLayout mLinear;
        private final LinearLayout mHotLinear;
        private final JCVideoPlayerStandard mJcPlayer;

        public MyItemHolder(View itemView) {
            super(itemView);
            mSimple = itemView.findViewById(R.id.hot_simple);
            mName = itemView.findViewById(R.id.hot_name);
            mCreateTime = itemView.findViewById(R.id.hot_createTime);
            mAnim = itemView.findViewById(R.id.hot_anim);
            mTitle = itemView.findViewById(R.id.hot_title);
//            mPlayerSimpler = itemView.findViewById(R.id.player_simple);
            mJcPlayer = itemView.findViewById(R.id.jc_player);

//            mSwitch = itemView.findViewById(R.id.switch_simple);
            mLike = itemView.findViewById(R.id.play_like);
            mCollection = itemView.findViewById(R.id.play_collection);
            mShare = itemView.findViewById(R.id.play_share);
            mPlayMessage = itemView.findViewById(R.id.play_message);
            mUser = itemView.findViewById(R.id.hot_user);
            mMessage = itemView.findViewById(R.id.hot_message);
            mLinear = itemView.findViewById(R.id.play_linear);
            mHotLinear = itemView.findViewById(R.id.hot_linear);

        }
    }
}
