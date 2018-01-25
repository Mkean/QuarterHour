package com.bwie.quarterhour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected boolean isDebug = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        setListener();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    protected abstract void setListener();

    //findViewById
    public <T extends View> T $findViewById(int resId) {
        return (T) findViewById(resId);
    }

    //log
    protected void $Log(String msg) {
        if (isDebug) {
            Log.e(this.getClass().getName(), msg);
        }
    }

    //toast
    protected void $Toast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //toast
    protected void $Toast(int resId) {
        Toast.makeText(this, resId + "", Toast.LENGTH_SHORT).show();
    }

    //startActivity
    protected void $startActivity(Class<?> cls) {
        $startActivity(cls, null);
    }

    //startActivity
    protected void $startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    // startActivityForResult
    protected void $startActivityForResult(Class<?> cls, int requestCode) {
        $startActivityForResult(cls, null, requestCode);
    }

    // startActivityForResult
    protected void $startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    // getIntent
    protected Bundle $getIntentExtra() {
        Intent intent = getIntent();
        Bundle bundle = null;
        if (null != intent)
            bundle = intent.getExtras();
        return bundle;
    }

    /**
     * view点击
     *
     * @param v
     */
    public abstract void widgetClick(View v);

    private long lastClick = 0;

    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (fastClick()) {
            widgetClick(v);
        }
    }
}
