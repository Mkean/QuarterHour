package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.LoginBean;
import com.bwie.quarterhour.model.LoginModel;
import com.bwie.quarterhour.view.LoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class LoginPresenter extends IPresenter<LoginView> {

    private LoginModel loginModel;

    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected void init() {
        loginModel = new LoginModel();
    }

    public void login(String mobile, String password) {
        if (view.get() == null) {
            return;
        }
        if (mobile.equals("") || password.equals("")) {
            view.get().isEmpty();
            return;
        }
        if (password.length() < 6) {
            view.get().passLength();
            return;
        }


        Observable<LoginBean> login = loginModel.login(mobile, password);
        if (login == null) {
            return;
        }
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().loginSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().loginFailed(throwable);
                    }
                });
    }
}
