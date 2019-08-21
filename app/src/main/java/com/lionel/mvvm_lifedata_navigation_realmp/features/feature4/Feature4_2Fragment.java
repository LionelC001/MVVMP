package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature42Binding;


public class Feature4_2Fragment extends BaseFragment {


    private FragmentFeature42Binding dataBinding;
    private Button btnNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature4_2, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initScrollListener();
        initView();
        initViewModel();
        initListener();
    }

    private void initScrollListener() {
        setSwipeBackListener(dataBinding.getRoot());
    }

    private void initView() {
        btnNext = dataBinding.btnNext;
    }

    private void initViewModel() {

    }

    private void initListener() {
        btnNext.setOnClickListener(v -> navController.navigate(R.id.action_feature4_2Fragment_to_feature4_3Fragment));
    }
}
