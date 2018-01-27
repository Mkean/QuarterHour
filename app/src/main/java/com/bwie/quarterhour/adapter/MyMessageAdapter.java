package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.VideoDetailsBean;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class MyMessageAdapter extends RecyclerView.Adapter<MyMessageAdapter.MyMessageHolder> {

    private List<VideoDetailsBean.DataBean.CommentsBean> list;
    private Context context;

    public MyMessageAdapter(List<VideoDetailsBean.DataBean.CommentsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyMessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_item, parent, false);

        return new MyMessageHolder(view);
    }

    @Override
    public void onBindViewHolder(MyMessageHolder holder, int position) {
        holder.mUser.setText(list.get(position).getNickname() + "：");
        holder.mContent.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyMessageHolder extends RecyclerView.ViewHolder {

        private final TextView mUser;
        private final TextView mContent;

        public MyMessageHolder(View itemView) {
            super(itemView);
            mUser = itemView.findViewById(R.id.message_user);
            mContent = itemView.findViewById(R.id.message_content);
        }
    }
}
