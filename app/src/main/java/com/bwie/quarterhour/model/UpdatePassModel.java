package com.bwie.quarterhour.model;

import com.bwie.quarterhour.api.MyApi;
import com.bwie.quarterhour.bean.UpdatePassBean;
import com.bwie.quarterhour.constant.MyWeb;
import com.bwie.quarterhour.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class UpdatePassModel implements IModel {
    public Observable<UpdatePassBean> updatePass(String uid, String oldPass, String NewPass) {
        MyApi myApi = RetrofitManager.getInstance(MyWeb.Log).getmRetrofit().create(MyApi.class);
        return myApi.updatePass(uid, oldPass, NewPass);
    }
}
