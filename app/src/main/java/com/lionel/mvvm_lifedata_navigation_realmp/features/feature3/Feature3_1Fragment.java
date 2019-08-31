package com.lionel.mvvm_lifedata_navigation_realmp.features.feature3;


import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature31Binding;

import java.util.ArrayList;
import java.util.List;


public class Feature3_1Fragment extends BaseFragment {

    private FragmentFeature31Binding dataBinding;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature3_1;
    }

    @Override
    protected boolean getIsEnableBack() {
        return true;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature31Binding) baseDataBinding;

        initViewPager();
    }

    private void initViewPager() {
        List<Integer> data = initViewData();
        ViewPager viewPager = dataBinding.viewPager;
        Feature3_1ViewAdapter adapter = new Feature3_1ViewAdapter(getActivity(), data);
        viewPager.setAdapter(adapter);
        TabLayout tabLayoutTab = dataBinding.tabLayoutDot;
        tabLayoutTab.setupWithViewPager(viewPager);
    }

    private List<Integer> initViewData() {
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.bg_1);
        data.add(R.drawable.bg_2);
        data.add(R.drawable.bg_3);
        data.add(R.drawable.bg_4);
        data.add(R.drawable.bg_5);
        data.add(R.drawable.bg_6);
        data.add(R.drawable.bg_7);
        data.add(R.drawable.bg_8);
        data.add(R.drawable.bg_9);
        data.add(R.drawable.bg_10);
        return data;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initObserve() {

    }

}
