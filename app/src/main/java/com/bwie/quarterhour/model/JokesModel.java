package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.JokeBean;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/25
 */

public class JokesModel implements IModel {
    public Observable<JokeBean> releaseJokes(String uid, String content, String token) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.releaseJokes(uid, content, token);
    }
}
