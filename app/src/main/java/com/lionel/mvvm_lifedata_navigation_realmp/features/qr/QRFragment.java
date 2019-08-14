package com.lionel.mvvm_lifedata_navigation_realmp.features.qr;


import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentQrBinding;


public class QRFragment extends BaseFragment {


    private FragmentQrBinding dataBinding;

    public QRFragment() {

    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_qr;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navFeature4HostFragment;
    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentQrBinding) baseDataBinding;
    }

    @Override
    protected void initListener() {

    }

}
