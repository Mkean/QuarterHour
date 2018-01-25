package com.bwie.quarterhour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.quarterhour.activity.BaseActivity;
import com.bwie.quarterhour.activity.CreationActivity;
import com.bwie.quarterhour.activity.LoginActivity;
import com.bwie.quarterhour.bean.UserInfoBean;
import com.bwie.quarterhour.fragment.EpisodeFragment;
import com.bwie.quarterhour.fragment.RecommendFragment;
import com.bwie.quarterhour.fragment.VideoFragment;
import com.bwie.quarterhour.presenter.InfoPresenter;
import com.bwie.quarterhour.view.InfoView;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, InfoView {
    //头像
    private SimpleDraweeView mSimple;
    //title
    private TextView mRecommend;
    //编辑
    private ImageView mEdit;
    private RadioGroup mRg;
    //fragment
    private VideoFragment video;
    private EpisodeFragment episode;
    private RecommendFragment recommend;
    private FragmentManager manager;
    private RadioButton mBt;
    //侧拉控件
    private DrawerLayout mDrawer;
    //侧拉菜单
    private LinearLayout mSideMenu;
    //登录
    private SimpleDraweeView mDrawerSimple;
    //昵称
    private TextView mNickName;
    //性别
    private SimpleDraweeView mGender;
    //签名
    private TextView mSignature;
    //我的关注
    private TextView mAttention;
    //我的收藏
    private TextView mCollection;
    //搜索好友
    private TextView mSearch;
    //消息通知
    private TextView mMessage;
    private SharedPreferences preferences;


    @Override
    protected void initData() {
        getFragmentList();
        mSimple.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1499936862);
        mDrawerSimple.setImageURI("res://com.bwie.quarterhour/" + R.drawable.raw_1499936862);
        mGender.setImageURI("res://com.bwie.quarterhour/" + R.drawable.gender);
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, recommend).commit();
        mBt.setChecked(true);
        getShared();
        InfoPresenter infoPresenter = new InfoPresenter(this);
        String uid = preferences.getString("uid", "");
        String token = preferences.getString("token", "");
        if (uid.equals("") || token.equals("")) {
            return;
        }
        infoPresenter.getInfo(uid, token);
    }

    private void getShared() {
        preferences = getSharedPreferences("data", MODE_PRIVATE);
    }


    private void getFragmentList() {
        recommend = new RecommendFragment();
        episode = new EpisodeFragment();
        video = new VideoFragment();
    }

    //初始化组件
    @Override
    protected void initView() {
        mSimple = $findViewById(R.id.title_simple);
        mRecommend = $findViewById(R.id.title_recommend);
        mEdit = $findViewById(R.id.title_edit);
        mRg = $findViewById(R.id.rg);
        mBt = $findViewById(R.id.bt1);
        mSideMenu = $findViewById(R.id.sideMenu);
        mDrawer = $findViewById(R.id.drawer);
        mDrawerSimple = $findViewById(R.id.drawer_simple);
        mNickName = $findViewById(R.id.nickName);
        mGender = $findViewById(R.id.gender);
        mSignature = $findViewById(R.id.signature);
        mAttention = $findViewById(R.id.bt_attention);
        mCollection = $findViewById(R.id.bt_collection);
        mSearch = $findViewById(R.id.bt_search);
        mMessage = $findViewById(R.id.bt_message);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //点击监听
    @Override
    protected void setListener() {
        mEdit.setOnClickListener(this);
        mRg.setOnCheckedChangeListener(this);
        mSimple.setOnClickListener(this);
        mDrawerSimple.setOnClickListener(this);
        mAttention.setOnClickListener(this);
        mCollection.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mMessage.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            //编辑
            case R.id.title_edit:
                $startActivity(CreationActivity.class);
                break;
            //侧拉
            case R.id.title_simple:
                mDrawer.openDrawer(mSideMenu);
                break;
            //登录
            case R.id.drawer_simple:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            //关注
            case R.id.bt_attention:

                break;
            //收藏
            case R.id.bt_collection:
                break;
            //查询
            case R.id.bt_search:
                break;
            //消息
            case R.id.bt_message:
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.bt1:
                manager.beginTransaction().replace(R.id.frame, recommend).commit();
                break;
            case R.id.bt2:
                manager.beginTransaction().replace(R.id.frame, episode).commit();
                break;
            case R.id.bt3:
                manager.beginTransaction().replace(R.id.frame, video).commit();
                break;

        }
    }

    @Override
    public void getInfoSuccess(UserInfoBean userInfoBean) {
        if (userInfoBean.getCode().equals("0")) {
            UserInfoBean.DataBean data = userInfoBean.getData();
            mNickName.setText(data.getNickname());
        } else {
            $Toast(userInfoBean.getMsg());
        }
    }

    @Override
    public void getInfoFailed(Throwable e) {
        $Toast("请求个人信息失败");
        $Log(e.getMessage().toString());
    }
}
