package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.RegisterBean;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public interface RegisterView extends IView {
    void isEmpty();

    void passLength();

    void registerSuccess(RegisterBean registerBean);

    void registerFailed(Throwable e);
}
