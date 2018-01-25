package com.bwie.quarterhour.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class MyApp extends Application {
    public static boolean isLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
        initImageLoader();
    }

    private void initImageLoader() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }

    private void initFresco() {
        Fresco.initialize(this);
    }
}
