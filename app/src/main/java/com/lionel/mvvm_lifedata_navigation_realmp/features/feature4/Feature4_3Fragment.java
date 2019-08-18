package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature42Binding;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature43Binding;


public class Feature4_3Fragment extends BaseFragment {

    private FragmentFeature43Binding dataBinding;
    private Button btnDone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature4_3, container, false);
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
        btnDone = dataBinding.btnDone;
    }

    private void initViewModel() {

    }

    private void initListener() {
        btnDone.setOnClickListener(v -> navController.navigate(R.id.action_feature4_3Fragment_to_feature4Fragment));
    }
}
