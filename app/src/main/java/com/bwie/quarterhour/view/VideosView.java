package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.VideosBean;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public interface VideosView extends IView {
    void getVideosSuccess(VideosBean videosBean);

    void getVideosFailed(Throwable e);
}
