package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.widget.ImageButton;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature2Binding;

public class Feature2Fragment extends BaseFragment {

    private FragmentFeature2Binding dataBinding;
    private ImageButton btn;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature2;
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
        dataBinding = (FragmentFeature2Binding) baseDataBinding;
        btn = dataBinding.btn;
    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(v -> navController.navigate(R.id.action_feature2Fragment_to_feature2_1Fragment));
    }

    @Override
    protected void initObserve() {

    }
}
