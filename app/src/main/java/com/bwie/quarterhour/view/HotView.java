package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.HotBean;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public interface HotView extends IView {
    void getHotSuccess(HotBean hotBean);

    void getHotFailed(Throwable e);
}
