package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;

import android.widget.Button;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature42Binding;


public class Feature4_2Fragment extends BaseFragment {


    private FragmentFeature42Binding dataBinding;
    private Button btnNext;

    public Feature4_2Fragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_2;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navFeature4HostFragment;
    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature42Binding) baseDataBinding;
        btnNext = dataBinding.btnNext;
    }

    @Override
    protected void initListener() {
        btnNext.setOnClickListener(v -> navController.navigate(R.id.action_feature4_2Fragment_to_feature4_3Fragment));
    }
}
