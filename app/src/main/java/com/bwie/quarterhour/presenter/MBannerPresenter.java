package com.bwie.quarterhour.presenter;

import android.util.Log;

import com.bwie.quarterhour.bean.MBanner;
import com.bwie.quarterhour.model.MBannerModel;
import com.bwie.quarterhour.view.MBannerView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class MBannerPresenter extends IPresenter<MBannerView> {

    private MBannerModel mBannerModel;

    public MBannerPresenter(MBannerView view) {
        super(view);
    }

    @Override
    protected void init() {
        mBannerModel = new MBannerModel();
    }

    public void getBanner() {
        Observable<MBanner> banner = mBannerModel.getBanner();
        if (banner != null) {
            banner.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<MBanner>() {
                        @Override
                        public void accept(MBanner banner) throws Exception {
                            if (view != null) {
                                Log.e("TAG", "======" + view.get() + "|======");
                                if (view.get() == null) {
                                    return;
                                }
                                view.get().getBannerSuccess(banner);
                            } else {
                                return;
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            if (view != null) {
                                if (view.get() == null) {
                                    return;
                                }
                                Log.e("TAG1", "======" + view.get() + "|======");
                                view.get().getBannerFailed(throwable);
                            } else {
                                return;
                            }
                        }
                    });
        } else {
            return;
        }
    }
}
