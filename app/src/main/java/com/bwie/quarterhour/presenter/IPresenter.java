package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.view.IView;

import java.lang.ref.WeakReference;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public abstract class IPresenter<T extends IView> {
    protected WeakReference<T> view;

    public IPresenter(T view) {
        this.view = new WeakReference<T>(view);
        init();
    }

    protected abstract void init();

    public void detach() {
        view.clear();
    }
}
