package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.widget.Button;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature41Binding;


public class feature4_1Fragment extends BaseFragment {


    private FragmentFeature41Binding dataBinding;
    private Button btnNext;

    public feature4_1Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_1;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navFeature4HostFragment;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature41Binding) baseDataBinding;
        btnNext = dataBinding.btnNext;
    }

    @Override
    protected void initListener() {
        btnNext.setOnClickListener(v -> navController.navigate(R.id.action_feature4_1Fragment_to_feature4_2Fragment));
    }
}
