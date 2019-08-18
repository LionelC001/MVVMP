package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature2Binding;

public class Feature2Fragment extends BaseFragment {


    private FragmentFeature2Binding dataBinding;
    private ImageButton btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature2, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initViewModel();
        initListener();
    }

    private void initView() {
        btn = dataBinding.btn;
    }

    private void initViewModel() {

    }

    private void initListener() {
        btn.setOnClickListener(v -> navController.navigate(R.id.action_feature2Fragment_to_feature2_1Fragment));
    }
}
