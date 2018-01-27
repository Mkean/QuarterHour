package com.bwie.quarterhour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.quarterhour.R;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class NearVideosFragment extends LazyFragment {
    private boolean isPrepare;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.nearvideos_layout, container, false);
        initView();
        isPrepare = true;
        LazyLoad();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView() {

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
    }
}
