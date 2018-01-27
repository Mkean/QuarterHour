package com.bwie.quarterhour.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.adapter.MyHotItemAdapter;
import com.bwie.quarterhour.bean.MBanner;
import com.bwie.quarterhour.bean.VideosBean;
import com.bwie.quarterhour.presenter.MBannerPresenter;
import com.bwie.quarterhour.presenter.VideosPresenter;
import com.bwie.quarterhour.utils.ImageUtils;
import com.bwie.quarterhour.view.MBannerView;
import com.bwie.quarterhour.view.VideosView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class HotFragment extends LazyFragment implements MBannerView, VideosView {
    private boolean isPrepared;
    private View view;
    private MBannerPresenter mBannerPresenter;
    private RecyclerView mLv;
    private SharedPreferences preferences;
    private Banner mBanner;
    private MyHotItemAdapter adapter;
    private VideosPresenter videosPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hot_layout, container, false);
        initView();
        isPrepared = true;
        LazyLoad();
        return view;
    }

    private void initView() {
        mLv = view.findViewById(R.id.hot_lv);
        mBanner = view.findViewById(R.id.hot_banner);
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
        if (!isPrepared || !isVisible) {
            return;
        }
        preferences = getContext().getSharedPreferences("data", MODE_PRIVATE);
        videosPresenter = new VideosPresenter(this);
        videosPresenter.getVideos(preferences.getString("uid", ""), "1", 1);

        mBannerPresenter = new MBannerPresenter(this);
        mBannerPresenter.getBanner();

    }

    @Override
    public void getBannerSuccess(MBanner banner) {
        String code = banner.getCode();
        if (code.equals("0")) {
            List<MBanner.DataBean> data = banner.getData();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                list.add(data.get(i).getIcon());
            }

            mBanner.setImageLoader(new ImageUtils());
            mBanner.setImages(list);
            mBanner.start();
        }
    }

    @Override
    public void getBannerFailed(Throwable e) {
        Toast.makeText(getContext(), "请求banner图失败", Toast.LENGTH_SHORT).show();
        Log.e("HotFragment", e.getMessage().toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBannerPresenter != null) {
            mBannerPresenter.detach();
        }
        if (videosPresenter != null) {
            videosPresenter.detach();
        }
    }

    @Override
    public void getVideosSuccess(VideosBean videosBean) {
        if (videosBean.getCode().equals("0")) {
            List<VideosBean.DataBean> data = videosBean.getData();
            adapter = new MyHotItemAdapter(data, getContext());
            mLv.setLayoutManager(new LinearLayoutManager(getContext()));
            mLv.setAdapter(adapter);
        } else {
            Toast.makeText(getContext(), videosBean.getMsg() + "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getVideosFailed(Throwable e) {
        Toast.makeText(getContext(), "请求数据失败", Toast.LENGTH_SHORT).show();
        Log.e("HotFragment", e.getMessage().toString());
    }
}
