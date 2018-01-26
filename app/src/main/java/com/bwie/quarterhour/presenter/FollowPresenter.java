package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.FollowBean;
import com.bwie.quarterhour.model.FollowModel;
import com.bwie.quarterhour.view.FollowView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public class FollowPresenter extends IPresenter<FollowView> {

    private FollowModel followModel;

    public FollowPresenter(FollowView view) {
        super(view);
    }

    @Override
    protected void init() {
        followModel = new FollowModel();
    }

    public void follow(String uid, String followId, String token) {
        Observable<FollowBean> follow = followModel.follow(uid, followId, token);
        follow.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FollowBean>() {
                    @Override
                    public void accept(FollowBean followBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().followSuccess(followBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().followFailed(throwable);
                    }
                });
    }
}
