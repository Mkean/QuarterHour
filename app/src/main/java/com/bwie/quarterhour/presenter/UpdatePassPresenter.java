package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.UpdatePassBean;
import com.bwie.quarterhour.model.UpdatePassModel;
import com.bwie.quarterhour.view.UpdatePassView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class UpdatePassPresenter extends IPresenter<UpdatePassView> {

    private UpdatePassModel updatePassModel;

    public UpdatePassPresenter(UpdatePassView view) {
        super(view);
    }

    @Override
    protected void init() {
        updatePassModel = new UpdatePassModel();
    }

    public void updatePass(String uid, String oldPass, String NewPass, String pwd) {
        if (view.get() == null) {
            return;
        }
        if (NewPass.equals("") || pwd.equals("")) {
            view.get().isEmpty();
            return;
        }
        if (NewPass.length() < 6 || pwd.length() < 6) {
            view.get().isLength();
            return;
        }
        if (!NewPass.equals(pwd)) {
            view.get().isEqual();
            return;
        }
        Observable<UpdatePassBean> updatePass = updatePassModel.updatePass(uid, oldPass, NewPass);
        updatePass.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UpdatePassBean>() {
                    @Override
                    public void accept(UpdatePassBean updatePassBean) throws Exception {
                        view.get().updateSuccess(updatePassBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().updateFailed(throwable);
                    }
                });
    }
}
