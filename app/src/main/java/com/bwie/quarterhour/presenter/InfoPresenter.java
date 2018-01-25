package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.UserInfoBean;
import com.bwie.quarterhour.model.InfoModel;
import com.bwie.quarterhour.view.InfoView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class InfoPresenter extends IPresenter<InfoView> {

    private InfoModel infoModel;

    public InfoPresenter(InfoView view) {
        super(view);
    }

    @Override
    protected void init() {
        infoModel = new InfoModel();
    }

    public void getInfo(String uid, String token) {
        if (view.get() == null) {
            return;
        }
        Observable<UserInfoBean> info = infoModel.getInfo(uid, token);
        info.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfoBean>() {
                    @Override
                    public void accept(UserInfoBean userInfoBean) throws Exception {
                        view.get().getInfoSuccess(userInfoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().getInfoFailed(throwable);
                    }
                });

    }
}
