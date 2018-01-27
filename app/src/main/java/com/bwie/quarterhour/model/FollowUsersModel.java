package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.FollowUsers;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public class FollowUsersModel implements IModel {
    public Observable<FollowUsers> getFollowUsers(String uid, String token) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.getFollowUsers(uid, token);
    }
}
