package com.lionel.mvvm_lifedata_navigation_realmp.features.qr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;


public class QRFragment extends BaseFragment {


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
    protected void initListener() {

    }

}
