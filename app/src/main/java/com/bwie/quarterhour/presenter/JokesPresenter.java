package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.JokeBean;
import com.bwie.quarterhour.model.JokesModel;
import com.bwie.quarterhour.view.JokesView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/25
 */

public class JokesPresenter extends IPresenter<JokesView> {

    private JokesModel jokesModel;

    public JokesPresenter(JokesView view) {
        super(view);
    }

    @Override
    protected void init() {
        jokesModel = new JokesModel();
    }

    public void releaseJokes(String uid, String content, String token) {
        if (view.get() == null) {
            return;
        }
        Observable<JokeBean> jokes = jokesModel.releaseJokes(uid, content, token);
        jokes.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JokeBean>() {
                    @Override
                    public void accept(JokeBean jokeBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().releaseSuccess(jokeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().releaseFailed(throwable);
                    }
                });
    }
}
