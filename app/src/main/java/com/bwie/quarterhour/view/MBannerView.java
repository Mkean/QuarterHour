package com.bwie.quarterhour.view;

import com.bwie.quarterhour.bean.MBanner;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public interface MBannerView extends IView {
    void getBannerSuccess(MBanner banner);

    void getBannerFailed(Throwable e);
}
