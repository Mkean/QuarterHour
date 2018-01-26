package com.bwie.quarterhour.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.utils.ImageUtils;
import com.youth.banner.Banner;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class MyHotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private Context context;
    private List<EpisodeBean.DataBean> data;

    private enum Type_Item {
        TYPE0, TYPE1;
    }

    public MyHotAdapter(List<String> list, Context context, List<EpisodeBean.DataBean> data) {
        this.list = list;
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Type_Item.TYPE0.ordinal()) {
            View view = LayoutInflater.from(context).inflate(R.layout.mbanner_layout, parent, false);
            MyBannerHolder holder = new MyBannerHolder(view);
            return holder;
        } else if (viewType == Type_Item.TYPE1.ordinal()) {
            View view = LayoutInflater.from(context).inflate(R.layout.hot_item_layout, parent, false);
            MyHotHolder holder = new MyHotHolder(view);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyBannerHolder) {
            ((MyBannerHolder) holder).mBanner.setImageLoader(new ImageUtils());
            ((MyBannerHolder) holder).mBanner.setImages(list);
            ((MyBannerHolder) holder).mBanner.start();
        }
        if (holder instanceof MyHotHolder) {
            if (data == null) {
                Toast.makeText(context, "请求数据失败", Toast.LENGTH_SHORT).show();
                return;
            }
            MyHotItemAdapter adapter = new MyHotItemAdapter(data, context);
            ((MyHotHolder) holder).mLv.setLayoutManager(new LinearLayoutManager(context));
            ((MyHotHolder) holder).mLv.setAdapter(adapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Type_Item.TYPE0.ordinal();
        } else if (position == 1) {
            return Type_Item.TYPE1.ordinal();
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    class MyBannerHolder extends RecyclerView.ViewHolder {

        private final Banner mBanner;

        public MyBannerHolder(View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.hot_banner);
        }
    }

    class MyHotHolder extends RecyclerView.ViewHolder {

        private final RecyclerView mLv;

        public MyHotHolder(View itemView) {
            super(itemView);
            mLv = itemView.findViewById(R.id.hotItem_lv);
        }
    }
}
