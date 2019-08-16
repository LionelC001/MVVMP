package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;


import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature21Binding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feature2_1Fragment extends BaseFragment {


    private FragmentFeature21Binding dataBinding;
    private Feature2ViewModel viewModel;

    public Feature2_1Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature2_1;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navMainHostFragment;
    }

    @Override
    protected void initViewModel() {
        viewModel = new ViewModelProvider(this).get(Feature2ViewModel.class);
    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature21Binding) baseDataBinding;
    }

    @Override
    protected void initListener() {
    }
}
