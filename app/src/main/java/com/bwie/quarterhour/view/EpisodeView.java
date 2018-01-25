package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.EpisodeBean;

/**
 * 作者：王庆
 * 时间：2018/1/24
 */

public interface EpisodeView extends IView {
    void getJokesSuccess(EpisodeBean episodeBean);

    void getJokesFailed(Throwable e);
}
