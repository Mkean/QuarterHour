package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.VideoDetailsBean;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public interface VideoDetailsView extends IView {
    void getVideoDetailsSuccess(VideoDetailsBean videoDetailsBean);

    void getVideoDetailsFailed(Throwable e);
}
