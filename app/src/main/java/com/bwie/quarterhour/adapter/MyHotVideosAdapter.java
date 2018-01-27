package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class MyHotVideosAdapter extends RecyclerView.Adapter<MyHotVideosAdapter.MyHotVideosHolder> {
    private List<VideoBean.DataBean> list;
    private Context context;
    private List<String> listImg;
    private onItemClickListener mListener;

    public MyHotVideosAdapter(List<VideoBean.DataBean> list, Context context, List<String> listImg) {
        this.list = list;
        this.context = context;
        this.listImg = listImg;
    }

    public void setMListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface onItemClickListener {
        void onItemClickListener(View view, int position);
    }


    @Override
    public MyHotVideosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotvideos_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClickListener(v, (Integer) v.getTag());
                }
            }
        });
        return new MyHotVideosHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHotVideosHolder holder, int position) {
        VideoBean.DataBean dataBean = list.get(position);
        holder.mSimple.setImageURI(Uri.parse(listImg.get(position)));
        List<VideoBean.DataBean.CommentsBean> comments = dataBean.getComments();
        holder.mNum.setText(dataBean.getCommentNum());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyHotVideosHolder extends RecyclerView.ViewHolder {

        private final TextView mNum;
        private final SimpleDraweeView mSimple;

        public MyHotVideosHolder(View itemView) {
            super(itemView);
            mSimple = itemView.findViewById(R.id.videos_simple);
            mNum = itemView.findViewById(R.id.message_num);
        }
    }
}
