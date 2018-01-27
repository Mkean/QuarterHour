package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.VideoBean;
import com.bwie.quarterhour.model.VideosModel;
import com.bwie.quarterhour.view.VideosView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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

    public void getHotVideos(int page) {
        Observable<VideoBean> hotVideos = videosModel.getHotVideos(page);
        hotVideos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoBean>() {
                    @Override
                    public void accept(VideoBean videoBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getHotVideosSuccess(videoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getHotVideosFailed(throwable);
                    }
                });
    }
}
