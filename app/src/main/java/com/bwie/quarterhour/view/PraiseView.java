package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.PraiseBean;

/**
 * 作者：王庆
 * 时间：2018/1/28
 */

public interface PraiseView extends IView {
    void praiseSuccess(PraiseBean praiseBean);

    void praiseFailed(Throwable e);
}
