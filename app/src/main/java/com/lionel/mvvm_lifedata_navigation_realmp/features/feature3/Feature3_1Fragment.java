package com.lionel.mvvm_lifedata_navigation_realmp.features.feature3;


import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IToolbarSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature31Binding;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ToolbarNormalBinding;


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

        initToolbar();
        initViewPager();
    }

    private void initToolbar() {
        ((IToolbarSetter) getActivity()).showToolbar(false);

        ToolbarNormalBinding toolbar = dataBinding.layoutToolbar;
        toolbar.txtTitle.setText("Feature3_1");
        toolbar.imgBack.setVisibility(View.VISIBLE);
        toolbar.imgBack.setOnClickListener(v -> onSwipeBack());
    }

    private void initViewPager() {
        ViewPager viewPager = dataBinding.viewPager;
        TabLayout tabLayoutTab = dataBinding.tabLayoutDot;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initObserve() {

    }

}
