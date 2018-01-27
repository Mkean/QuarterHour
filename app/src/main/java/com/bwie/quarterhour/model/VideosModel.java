package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.VideoBean;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideosModel implements IModel {
    public Observable<VideoBean> getHotVideos(int page) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.getHotVideos(page, "8BEDC01CA25B280B0104D9E9842C2CEB");
    }
}
