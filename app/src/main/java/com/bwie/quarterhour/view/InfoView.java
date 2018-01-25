package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.UserInfoBean;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public interface InfoView extends IView {
    void getInfoSuccess(UserInfoBean userInfoBean);

    void getInfoFailed(Throwable e);
}
