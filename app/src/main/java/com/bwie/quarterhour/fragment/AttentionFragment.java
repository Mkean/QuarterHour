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
import com.bwie.quarterhour.bean.VideosBean;
import com.bwie.quarterhour.presenter.VideosPresenter;
import com.bwie.quarterhour.view.VideosView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class AttentionFragment extends LazyFragment implements VideosView {
    private boolean isPrepare;
    private View view;
    private RecyclerView mLv;
    private SharedPreferences preferences;
    private VideosPresenter videosPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attention_layout, container, false);
        initView();
        isPrepare = true;
        LazyLoad();
        return view;
    }

    private void initView() {
        mLv = view.findViewById(R.id.attention_lv);
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
        preferences = getContext().getSharedPreferences("data", MODE_PRIVATE);
        videosPresenter = new VideosPresenter(this);
        videosPresenter.getVideos(preferences.getString("uid", ""), "1", 1);
    }

    @Override
    public void getVideosSuccess(VideosBean videosBean) {
        if (videosBean.getCode().equals("0")) {
            List<VideosBean.DataBean> data = videosBean.getData();
            MyHotItemAdapter adapter = new MyHotItemAdapter(data, getContext());
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videosPresenter != null) {
            videosPresenter.detach();
        }
    }
}
