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
import com.bwie.quarterhour.adapter.MyHotAdapter;
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.bean.MBanner;
import com.bwie.quarterhour.presenter.EpisodePresenter;
import com.bwie.quarterhour.presenter.MBannerPresenter;
import com.bwie.quarterhour.view.EpisodeView;
import com.bwie.quarterhour.view.MBannerView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class HotFragment extends LazyFragment implements MBannerView, EpisodeView {
    private boolean isPrepared;
    private View view;
    private MBannerPresenter mBannerPresenter;
    private RecyclerView mLv;
    private MyHotAdapter adapter;
    private SharedPreferences preferences;
    private EpisodePresenter episodePresenter;
    private List<EpisodeBean.DataBean> data;

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
        episodePresenter = new EpisodePresenter(this);
        episodePresenter.getJokes(2, preferences.getString("token", ""));

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
            adapter = new MyHotAdapter(list, getContext(), this.data);
            mLv.setLayoutManager(new LinearLayoutManager(getContext()));
            mLv.setAdapter(adapter);
        }
    }

    @Override
    public void getBannerFailed(Throwable e) {
        Toast.makeText(getContext(), "请求banner图失败", Toast.LENGTH_SHORT).show();
        Log.e("HotFragment", e.getMessage().toString());
    }


    @Override
    public void getJokesSuccess(EpisodeBean episodeBean) {
        if (episodeBean.getCode().equals("0")) {
            data = episodeBean.getData();
        } else {
            Toast.makeText(getContext(), episodeBean.getMsg() + "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getJokesFailed(Throwable e) {
        Toast.makeText(getContext(), "请求数据失败", Toast.LENGTH_SHORT).show();
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
        if (episodePresenter != null) {
            episodePresenter.detach();
        }
    }

}
