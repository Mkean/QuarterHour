package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.CommentBean;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class CommentModel implements IModel {
    public Observable<CommentBean> comment(String uid, String wid, String content, String token) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.comment(uid, wid, content, token);
    }
}
