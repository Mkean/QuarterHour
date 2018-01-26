package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.FollowBean;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public interface FollowView extends IView {
    void followSuccess(FollowBean followBean);

    void followFailed(Throwable e);
}
