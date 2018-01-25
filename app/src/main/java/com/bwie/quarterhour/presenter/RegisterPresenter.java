package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.RegisterBean;
import com.bwie.quarterhour.model.RegisterModel;
import com.bwie.quarterhour.view.RegisterView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class RegisterPresenter extends IPresenter<RegisterView> {

    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView view) {
        super(view);
    }

    @Override
    protected void init() {
        registerModel = new RegisterModel();
    }

    public void register(String mobile, String pass) {
        if (view.get() == null) {
            return;
        }
        if (mobile.equals("") || pass.equals("")) {
            view.get().isEmpty();
            return;
        }
        if (pass.length() < 6) {
            view.get().passLength();
            return;
        }
        Observable<RegisterBean> register = registerModel.register(mobile, pass);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        view.get().registerSuccess(registerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().registerFailed(throwable);
                    }
                });
    }
}
