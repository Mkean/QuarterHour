package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.model.EpisodeModel;
import com.bwie.quarterhour.view.EpisodeView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/24
 */

public class EpisodePresenter extends IPresenter<EpisodeView> {

    private EpisodeModel episodeModel;

    public EpisodePresenter(EpisodeView view) {
        super(view);
    }

    @Override
    protected void init() {
        episodeModel = new EpisodeModel();
    }

    public void getJokes(int page, String token) {
        if (view.get() == null) {
            return;
        }
        Observable<EpisodeBean> jokes = episodeModel.getJokes(page, token);
        jokes.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EpisodeBean>() {
                    @Override
                    public void accept(EpisodeBean episodeBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getJokesSuccess(episodeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getJokesFailed(throwable);
                    }
                });
    }
}
