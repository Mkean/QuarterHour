package com.bwie.quarterhour.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.adapter.EpisodeAdapter;
import com.bwie.quarterhour.bean.EpisodeBean;
import com.bwie.quarterhour.presenter.EpisodePresenter;
import com.bwie.quarterhour.view.EpisodeView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */
/*
*
* 段子详情
* */
public class EpisodeFragment extends Fragment implements EpisodeView {

    @InjectView(R.id.episode_lv)
    RecyclerView mEpisodeLv;
    private EpisodePresenter episodePresenter;
    private SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.episode_layout, container, false);
        ButterKnife.inject(this, view);
        initData();
        return view;
    }

    private void initData() {
        preferences = getContext().getSharedPreferences("data", MODE_PRIVATE);
        episodePresenter = new EpisodePresenter(this);
        episodePresenter.getJokes(2, preferences.getString("token", ""));
    }

    @Override
    public void getJokesSuccess(EpisodeBean episodeBean) {
        if (episodeBean.getCode().equals("0")) {
            List<EpisodeBean.DataBean> data = episodeBean.getData();
            EpisodeAdapter adapter = new EpisodeAdapter(data, getContext());
            mEpisodeLv.setLayoutManager(new LinearLayoutManager(getContext()));
            mEpisodeLv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            mEpisodeLv.setAdapter(adapter);
        } else {
            Toast.makeText(getContext(), episodeBean.getMsg() + "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getJokesFailed(Throwable e) {
        Toast.makeText(getContext(), "请求段子数据失败", Toast.LENGTH_SHORT).show();
        Log.e("EpisodeFragment", e.getMessage().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (episodePresenter != null) {
            episodePresenter.detach();
        }
    }
}
