package com.bwie.quarterhour.adapter;

import android.content.Context;
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
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.custom.AnimView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class MyHotItemAdapter extends RecyclerView.Adapter<MyHotItemAdapter.MyItemHolder> {
    private List<EpisodeBean.DataBean> list;
    private Context context;
    private boolean isVisible = false;

    public MyHotItemAdapter(List<EpisodeBean.DataBean> list, Context context) {
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
        final EpisodeBean.DataBean dataBean = list.get(position);
        EpisodeBean.DataBean.UserBean user = dataBean.getUser();
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
//        holder.mPlayerSimpler.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500978299);
        holder.mHotLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dataBean.getUid() + "", Toast.LENGTH_SHORT).show();
            }
        });
        holder.mJcPlayer.setUp("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4", "李少奇骑猪上高速");
        ImageView ivThumb = holder.mJcPlayer.ivThumb;
        Glide.with(context).load(R.drawable.raw_1500978299)
                .into(ivThumb);
//        holder.mJcPlayer.ivThumb.setImageResource(R.drawable.raw_1500978299);
//        holder.mJcPlayer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "sad", Toast.LENGTH_SHORT).show();
//                if (!isVisible) {
////                    holder.mSwitch.setVisibility(View.GONE);
//                    holder.mLinear.setVisibility(View.VISIBLE);
//                    isVisible = true;
//                } else {
////                    holder.mSwitch.setVisibility(View.VISIBLE);
//                    holder.mLinear.setVisibility(View.GONE);
//                    isVisible = false;
//                }
//            }
//        });
        holder.mJcPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sdf", Toast.LENGTH_SHORT).show();
            }
        });
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
        private final JCVideoPlayer mJcPlayer;

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
