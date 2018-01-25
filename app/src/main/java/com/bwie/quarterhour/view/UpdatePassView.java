package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.UpdatePassBean;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public interface UpdatePassView extends IView {
    void isEmpty();

    void isEqual();

    void isLength();

    void updateSuccess(UpdatePassBean updatePassBean);

    void updateFailed(Throwable e);
}
