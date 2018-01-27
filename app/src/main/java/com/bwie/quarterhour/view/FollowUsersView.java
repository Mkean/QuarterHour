package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.FollowUsers;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public interface FollowUsersView extends IView {
    void getFollowUsersSuccess(FollowUsers followUsers);

    void getFollowUsersFailed(Throwable e);
}
