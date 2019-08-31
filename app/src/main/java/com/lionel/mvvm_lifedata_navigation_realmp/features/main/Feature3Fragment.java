package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature3Binding;


public class Feature3Fragment extends BaseFragment {


    private FragmentFeature3Binding dataBinding;
    private Button btnGo;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature3;
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
        dataBinding = (FragmentFeature3Binding) baseDataBinding;
        btnGo = dataBinding.btnGo;
    }

    @Override
    protected void initListener() {
        btnGo.setOnClickListener(v -> navController.navigate(R.id.action_feature3Fragment_to_feature3_1Fragment));
    }

    @Override
    protected void initObserve() {

    }
}
