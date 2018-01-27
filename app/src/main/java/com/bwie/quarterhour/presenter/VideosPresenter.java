package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.model.VideosModel;
import com.bwie.quarterhour.view.VideosView;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideosPresenter extends IPresenter<VideosView> {

    private VideosModel videosModel;

    public VideosPresenter(VideosView view) {
        super(view);
    }

    @Override
    protected void init() {
        videosModel = new VideosModel();
    }
}
