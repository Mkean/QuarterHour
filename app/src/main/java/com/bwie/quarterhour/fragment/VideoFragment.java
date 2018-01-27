package com.bwie.quarterhour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.quarterhour.R;
import com.bwie.quarterhour.custom.NoScrollViewPage;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/22
 */

public class VideoFragment extends Fragment {
    private String[] titles = {"热门", "附近"};
    private View view;
    private TabLayout mTab;
    private NoScrollViewPage mViewPager;
    private List<Fragment> fragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.video_layout, container, false);
        initView();
        getFragment();
        initData();
        return view;
    }

    private void getFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HotVideosFragment());
        fragmentList.add(new NearVideosFragment());
    }

    private void initData() {
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList != null ? fragmentList.size() : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTab.setTabMode(TabLayout.GRAVITY_CENTER);
        mTab.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTab = view.findViewById(R.id.videos_tab);
        mViewPager = view.findViewById(R.id.videos_viewPager);
    }
}
