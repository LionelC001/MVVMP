package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature4Binding;


public class Feature4Fragment extends BaseFragment {


    public Feature4Fragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navMainHostFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initBtn();
    }

    private void initBtn() {
        ((FragmentFeature4Binding) dataBinding).btnNext.setOnClickListener(v -> {
            navController.navigate(R.id.feature4Activity);
        });
    }
}
