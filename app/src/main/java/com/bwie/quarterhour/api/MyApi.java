package com.bwie.quarterhour.api;

import com.bwie.quarterhour.bean.CommentBean;
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.bean.FollowBean;
import com.bwie.quarterhour.bean.FollowUsers;
import com.bwie.quarterhour.bean.JokeBean;
import com.bwie.quarterhour.bean.LoginBean;
import com.bwie.quarterhour.bean.MBanner;
import com.bwie.quarterhour.bean.PraiseBean;
import com.bwie.quarterhour.bean.RegisterBean;
import com.bwie.quarterhour.bean.UpdatePassBean;
import com.bwie.quarterhour.bean.UserInfoBean;
import com.bwie.quarterhour.bean.VideoBean;
import com.bwie.quarterhour.bean.VideoDetailsBean;
import com.bwie.quarterhour.bean.VideosBean;
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

    @GET(MyWeb.getJokes)
    Observable<EpisodeBean> getJokes(@Query("page") int page, @Query("token") String token);

    @GET(MyWeb.PublishJoke)
    Observable<JokeBean> releaseJokes(@Query("uid") String uid, @Query("content") String content, @Query("token") String token);

    @GET(follow)
    Observable<FollowBean> follow(@Query("uid") String uid, @Query("followId") String followId, @Query("token") String token);

    @GET(MyWeb.followUsers)
    Observable<FollowUsers> getFollowUsers(@Query("uid") String uid, @Query("token") String token);

    @GET(MyWeb.getHotVideos)
    Observable<VideoBean> getHotVideos(@Query("page") int page, @Query("token") String token);

    @GET(MyWeb.comment)
    Observable<CommentBean> comment(@Query("uid") String uid, @Query("wid") String wid, @Query("content") String content, @Query("token") String token);

    @GET(MyWeb.getVideosDetails)
    Observable<VideoDetailsBean> getVideoDetails(@Query("wid") String wid);

    @GET(MyWeb.getVideos)
    Observable<VideosBean> getVideos(@Query("uid") String uid, @Query("type") String type, @Query("page") int page);

    //作品点赞,
    @GET(MyWeb.praise)
    Observable<PraiseBean> praise(@Query("uid") String uid, @Query("wid") String wid, @Query("token") String token);
}
