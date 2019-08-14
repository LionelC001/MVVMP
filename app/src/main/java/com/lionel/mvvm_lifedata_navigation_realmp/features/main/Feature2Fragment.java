package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.widget.ImageButton;

import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature2Binding;

public class Feature2Fragment extends BaseFragment {


    private FragmentFeature2Binding dataBinding;
    private ImageButton btn;

    public Feature2Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature2;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navMainHostFragment;
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
}
