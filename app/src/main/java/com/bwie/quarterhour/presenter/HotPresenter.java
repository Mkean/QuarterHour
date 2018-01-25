package com.bwie.quarterhour.presenter;

import com.bwie.quarterhour.bean.HotBean;
import com.bwie.quarterhour.model.HotModel;
import com.bwie.quarterhour.view.HotView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class HotPresenter extends IPresenter<HotView> {

    private HotModel hotModel;

    public HotPresenter(HotView view) {
        super(view);
    }

    @Override
    protected void init() {
        hotModel = new HotModel();
    }

    public void getHot() {
        if (view.get() == null) {
            return;
        }
        Observable<HotBean> hot = hotModel.getHot();
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotBean>() {
                    @Override
                    public void accept(HotBean hotBean) throws Exception {
                        view.get().getHotSuccess(hotBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().getHotFailed(throwable);
                    }
                });
    }
}
