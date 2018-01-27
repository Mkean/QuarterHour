package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.CommentBean;
import com.bwie.quarterhour.model.CommentModel;
import com.bwie.quarterhour.view.CommentView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class CommentPresenter extends IPresenter<CommentView> {

    private CommentModel commentModel;

    public CommentPresenter(CommentView view) {
        super(view);
    }

    @Override
    protected void init() {
        commentModel = new CommentModel();
    }

    public void comment(String uid, String wid, String content, String token) {
        Observable<CommentBean> comment = commentModel.comment(uid, wid, content, token);
        comment.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentBean>() {
                    @Override
                    public void accept(CommentBean commentBean) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().commentSuccess(commentBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view.get() == null) {
                            return;
                        }
                        view.get().commentFailed(throwable);
                    }
                });
    }
}
