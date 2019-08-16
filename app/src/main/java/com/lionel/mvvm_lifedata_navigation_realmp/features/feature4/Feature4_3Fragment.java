package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.widget.Button;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature42Binding;


public class Feature4_3Fragment extends BaseFragment {


    private FragmentFeature42Binding dataBinding;
    private Button btnDone;

    public Feature4_3Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_3;
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
        dataBinding = (FragmentFeature42Binding) baseDataBinding;
        btnDone = dataBinding.btnNext;
    }

    @Override
    protected void initListener() {
        btnDone.setOnClickListener(v -> getActivity().finish());
    }
}
