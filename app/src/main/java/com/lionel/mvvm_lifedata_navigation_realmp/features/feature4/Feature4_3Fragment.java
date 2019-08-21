package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.widget.Button;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature43Binding;


public class Feature4_3Fragment extends BaseFragment {

    private FragmentFeature43Binding dataBinding;
    private Button btnDone;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_3;
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
        dataBinding = (FragmentFeature43Binding) baseDataBinding;
        btnDone = dataBinding.btnDone;
    }

    @Override
    protected void initListener() {
        btnDone.setOnClickListener(v -> navController.navigate(R.id.action_feature4_3Fragment_to_feature4Fragment));
    }

    @Override
    protected void initObserve() {

    }
}
