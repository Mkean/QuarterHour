package com.bwie.quarterhour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.quarterhour.R;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class AttentionFragment extends LazyFragment {
    private boolean isPrepare;
    private View view;
    private RecyclerView mLv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attention_layout, container, false);
        initView();
        isPrepare = true;
        LazyLoad();
        return super.onCreateView(inflater, container, savedInstanceState);
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
        if (!isPrepare || isVisible) {
            return;
        }
    }
}
