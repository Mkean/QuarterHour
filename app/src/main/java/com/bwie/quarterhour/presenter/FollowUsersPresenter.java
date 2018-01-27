package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.FollowUsers;
import com.bwie.quarterhour.model.FollowUsersModel;
import com.bwie.quarterhour.view.FollowUsersView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public class FollowUsersPresenter extends IPresenter<FollowUsersView> {

    private FollowUsersModel usersModel;

    public FollowUsersPresenter(FollowUsersView view) {
        super(view);
    }

    @Override
    protected void init() {
        usersModel = new FollowUsersModel();
    }

    public void getFollowUsers(String uid, String token) {
        Observable<FollowUsers> followUsers = usersModel.getFollowUsers(uid, token);
        followUsers.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FollowUsers>() {
                    @Override
                    public void accept(FollowUsers followUsers) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getFollowUsersSuccess(followUsers);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().getFollowUsersFailed(throwable);
                    }
                });
    }
}
