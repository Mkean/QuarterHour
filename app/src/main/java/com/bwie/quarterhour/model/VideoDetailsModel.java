package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.VideoDetailsBean;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideoDetailsModel implements IModel {
    public Observable<VideoDetailsBean> getVideoDetails(String wid) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.getVideoDetails(wid);
    }
}
