package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.PraiseBean;
import com.bwie.quarterhour.model.PraiseModel;
import com.bwie.quarterhour.view.PraiseView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/28
 */

public class PraisePresenter extends IPresenter<PraiseView> {

    private PraiseModel praiseModel;

    public PraisePresenter(PraiseView view) {
        super(view);
    }

    @Override
    protected void init() {
        praiseModel = new PraiseModel();
    }

    public void praise(String uid, String wid, String token) {
        Observable<PraiseBean> praise = praiseModel.praise(uid, wid, token);
        praise.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PraiseBean>() {
                    @Override
                    public void accept(PraiseBean praiseBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().praiseSuccess(praiseBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().praiseFailed(throwable);
                    }
                });
    }
}
