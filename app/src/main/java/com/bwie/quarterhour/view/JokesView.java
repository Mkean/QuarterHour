package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.JokeBean;

/**
 * 作者：王庆
 * 时间：2018/1/25
 */

public interface JokesView extends IView {
    void releaseSuccess(JokeBean jokeBean);

    void releaseFailed(Throwable e);
}
