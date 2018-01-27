package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.VideoDetailsBean;
import com.bwie.quarterhour.model.VideoDetailsModel;
import com.bwie.quarterhour.view.VideoDetailsView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideoDetailsPresenter extends IPresenter<VideoDetailsView> {

    private VideoDetailsModel videoDetailsModel;

    public VideoDetailsPresenter(VideoDetailsView view) {
        super(view);
    }

    @Override
    protected void init() {
        videoDetailsModel = new VideoDetailsModel();
    }

    public void getVideoDetails(String wid) {
        Observable<VideoDetailsBean> videoDetails = videoDetailsModel.getVideoDetails(wid);
        videoDetails.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoDetailsBean>() {
                    @Override
                    public void accept(VideoDetailsBean videoDetailsBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getVideoDetailsSuccess(videoDetailsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getVideoDetailsFailed(throwable);
                    }
                });
    }
}
