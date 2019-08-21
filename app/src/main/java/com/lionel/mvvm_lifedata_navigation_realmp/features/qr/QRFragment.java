package com.lionel.mvvm_lifedata_navigation_realmp.features.qr;


import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentQrBinding;


public class QRFragment extends BaseFragment {

    private FragmentQrBinding dataBinding;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_qr;
    }

    @Override
    protected boolean getIsEnableBack() {
        return true;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentQrBinding) baseDataBinding;

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initObserve() {

    }
}
