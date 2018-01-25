package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.LoginBean;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public interface LoginView extends IView {
    void isEmpty();

    void passLength();

    void loginSuccess(LoginBean loginBean);

    void loginFailed(Throwable e);
}
