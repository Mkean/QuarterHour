package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.model.JokesModel;
import com.bwie.quarterhour.view.JokesView;

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

    }
}
