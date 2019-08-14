package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature2Binding;

public class Feature2Fragment extends BaseFragment {


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
    protected void initListener() {
        ((FragmentFeature2Binding) dataBinding).btn.setOnClickListener(v -> navController.navigate(R.id.action_feature2Fragment_to_feature2_1Fragment));
    }
}
