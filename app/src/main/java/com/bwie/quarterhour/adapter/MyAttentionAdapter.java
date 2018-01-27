package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.FollowUsers;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public class MyAttentionAdapter extends RecyclerView.Adapter<MyAttentionAdapter.MyAttentionHolder> {
    private List<FollowUsers.DataBean> list;
    private Context context;

    public MyAttentionAdapter(List<FollowUsers.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyAttentionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.attention_item, parent, false);

        return new MyAttentionHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAttentionHolder holder, int position) {
        FollowUsers.DataBean dataBean = list.get(position);
        if (dataBean.getIcon() == null) {
            holder.mSimple.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1500002478);
        } else {
            holder.mSimple.setImageURI(Uri.parse((String) dataBean.getIcon()));
        }
        holder.mNickName.setText(dataBean.getNickname());
        holder.mCreateTime.setText(dataBean.getCreatetime());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyAttentionHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView mSimple;
        private final TextView mNickName;
        private final TextView mPersonality;
        private final TextView mCreateTime;

        public MyAttentionHolder(View itemView) {
            super(itemView);
            mCreateTime = itemView.findViewById(R.id.attention_createTime);
            mPersonality = itemView.findViewById(R.id.attention_personality);
            mNickName = itemView.findViewById(R.id.attention_nickName);
            mSimple = itemView.findViewById(R.id.attention_simple);
        }
    }
}
