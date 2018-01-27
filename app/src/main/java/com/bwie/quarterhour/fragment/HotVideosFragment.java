package com.bwie.quarterhour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.activity.DetailsActivity;
import com.bwie.quarterhour.adapter.MyHotVideosAdapter;
import com.bwie.quarterhour.bean.VideoBean;
import com.bwie.quarterhour.presenter.VideoPresenter;
import com.bwie.quarterhour.view.VideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class HotVideosFragment extends LazyFragment implements VideoView {
    private boolean isPrepare;
    private View view;
    private RecyclerView mLv;
    private VideoPresenter videosPresenter;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotvideos_layout, container, false);
        initView();
        isPrepare = true;
        getImg();
        LazyLoad();
        return view;
    }

    private void getImg() {
        list = new ArrayList<>();
        list.add("http://img5.imgtn.bdimg.com/it/u=2248907317,2456606936&fm=27&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2245363424,2283929512&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=2437536178,3823659508&fm=27&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=3056455437,4174103773&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=445905185,467876260&fm=27&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=1567211408,3977725624&fm=27&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=1145452263,1804140141&fm=27&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=871863603,4273902552&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=1781004794,3935582897&fm=27&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=1546379360,1793188636&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=3569457004,1571307316&fm=27&gp=0.jpg");
    }

    private void initView() {
        mLv = view.findViewById(R.id.hotVideos_lv);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            LazyLoad();
        }
    }

    @Override
    protected void LazyLoad() {
        if (!isPrepare || !isVisible) {
            return;
        }
        videosPresenter = new VideoPresenter(this);
        videosPresenter.getHotVideos(1);
    }

    @Override
    public void getHotVideosSuccess(final VideoBean videoBean) {
        if (videoBean.getCode().equals("0")) {
            final List<VideoBean.DataBean> data = videoBean.getData();
            MyHotVideosAdapter adapter = new MyHotVideosAdapter(data, getContext(), list);
            mLv.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutCompat.VERTICAL));
            adapter.setMListener(new MyHotVideosAdapter.onItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("wid", data.get(position).getWid());
                    startActivity(intent);
                }
            });
            mLv.setAdapter(adapter);
        } else {
            Toast.makeText(getContext(), videoBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getHotVideosFailed(Throwable e) {
        Toast.makeText(getContext(), "获取热门视频失败", Toast.LENGTH_SHORT).show();
        Log.e("HotVideosFragment", e.getMessage().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videosPresenter != null) {
            videosPresenter.detach();
        }
    }
}
