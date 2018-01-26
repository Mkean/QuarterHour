package com.bwie.quarterhour.api;

import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.bean.FollowBean;
import com.bwie.quarterhour.bean.HotBean;
import com.bwie.quarterhour.bean.JokeBean;
import com.bwie.quarterhour.bean.LoginBean;
import com.bwie.quarterhour.bean.MBanner;
import com.bwie.quarterhour.bean.RegisterBean;
import com.bwie.quarterhour.bean.UpdatePassBean;
import com.bwie.quarterhour.bean.UserInfoBean;
import com.bwie.quarterhour.constant.MyWeb;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.bwie.quarterhour.constant.MyWeb.follow;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public interface MyApi {
    //获取广告图
    @GET(MyWeb.mBanner)
    Observable<MBanner> getBanner();

    //登录
    @GET(MyWeb.Login)
    Observable<LoginBean> login(@Query("mobile") String mobile, @Query("password") String password);

    //注册
    @GET(MyWeb.Register)
    Observable<RegisterBean> register(@Query("mobile") String mobile, @Query("password") String password);

    //修改密码
    @GET(MyWeb.ResetPass)
    Observable<UpdatePassBean> updatePass(@Query("uid") String uid, @Query("oldPassword") String oldPassword, @Query("newPassword") String newPassword);

    @GET(MyWeb.UserInfo)
    Observable<UserInfoBean> getInfo(@Query("uid") String uid, @Query("token") String token);

    @GET
    Observable<HotBean> getHot();

    @GET(MyWeb.getJokes)
    Observable<EpisodeBean> getJokes(@Query("page") int page, @Query("token") String token);

    @GET(MyWeb.PublishJoke)
    Observable<JokeBean> releaseJokes(@Query("uid") String uid, @Query("content") String content, @Query("token") String token);

    @GET(follow)
    Observable<FollowBean> follow(@Query("uid") String uid, @Query("followId") String followId, @Query("token") String token);
}
