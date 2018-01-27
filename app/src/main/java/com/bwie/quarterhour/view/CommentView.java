package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.CommentBean;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public interface CommentView extends IView {
    void commentSuccess(CommentBean commentBean);

    void commentFailed(Throwable e);
}
