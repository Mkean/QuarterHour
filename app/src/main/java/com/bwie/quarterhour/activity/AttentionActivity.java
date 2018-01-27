package com.bwie.quarterhour.activity;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.TextView;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.adapter.MyAttentionAdapter;
import com.bwie.quarterhour.bean.FollowUsers;
import com.bwie.quarterhour.presenter.FollowUsersPresenter;
import com.bwie.quarterhour.view.FollowUsersView;

import java.util.List;

public class AttentionActivity extends BaseActivity implements FollowUsersView {

    private TextView mRight;
    private TextView mTitle;
    private LinearLayout mLeft;
    private RecyclerView mLv;
    private FollowUsersPresenter followUsersPresenter;

    @Override
    protected void initData() {
        mTitle.setText("我的关注");
        mRight.setText("热门关注");
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        followUsersPresenter = new FollowUsersPresenter(this);
        followUsersPresenter.getFollowUsers(preferences.getString("uid", ""), preferences.getString("token", ""));
    }

    @Override
    protected void initView() {
        mLeft = (LinearLayout) findViewById(R.id.text_left);
        mTitle = (TextView) findViewById(R.id.text_title);
        mRight = (TextView) findViewById(R.id.text_right);
        mLv = (RecyclerView) findViewById(R.id.attention_lv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attention;
    }

    @Override
    protected void setListener() {
        mRight.setOnClickListener(this);
        mLeft.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.text_left:
                finish();
                break;
            case R.id.text_right:

                break;

        }
    }

    @Override
    public void getFollowUsersSuccess(FollowUsers followUsers) {
        if (followUsers.getCode().equals("0")) {
            List<FollowUsers.DataBean> data = followUsers.getData();
            if (data != null) {
                MyAttentionAdapter adapter = new MyAttentionAdapter(data, this);
                mLv.setLayoutManager(new LinearLayoutManager(this));
                mLv.setAdapter(adapter);
            } else {
                $Toast("你还没有关注的人哟！");
            }
        } else {
            $Toast(followUsers.getMsg());
        }
    }

    @Override
    public void getFollowUsersFailed(Throwable e) {
        $Toast("请求数据失败");
        $Log(e.getMessage().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (followUsersPresenter != null) {
            followUsersPresenter.detach();
        }
    }
}
