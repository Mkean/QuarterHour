package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.activity.UserActivity;
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.custom.AnimView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/24
 */

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeHolder> {
    private List<EpisodeBean.DataBean> list;
    private Context context;

    public EpisodeAdapter(List<EpisodeBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public EpisodeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.episode_item, parent, false);
        EpisodeHolder holder = new EpisodeHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EpisodeHolder holder, int position) {
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
        holder.mContent.setText(dataBean.getContent());
        holder.mLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("uid", dataBean.getUid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class EpisodeHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView mSimple;
        private final AnimView mAnim;
        private final TextView mCreateTime;
        private final TextView mName;
        private final TextView mContent;
        private final LinearLayout mLinear;

        public EpisodeHolder(View itemView) {
            super(itemView);
            mSimple = itemView.findViewById(R.id.hot_simple);
            mName = itemView.findViewById(R.id.hot_name);
            mCreateTime = itemView.findViewById(R.id.hot_createTime);
            mAnim = itemView.findViewById(R.id.hot_anim);
            mContent = itemView.findViewById(R.id.episode_content);
            mLinear = itemView.findViewById(R.id.hot_linear);
        }
    }
}
