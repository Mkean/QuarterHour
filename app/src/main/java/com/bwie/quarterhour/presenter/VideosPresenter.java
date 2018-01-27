package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.VideosBean;
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

    public void getVideos(String uid, String type, int page) {
        final Observable<VideosBean> videos = videosModel.getVideos(uid, type, page);
        videos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideosBean>() {
                    @Override
                    public void accept(VideosBean videosBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getVideosSuccess(videosBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getVideosFailed(throwable);
                    }
                });
    }
}
