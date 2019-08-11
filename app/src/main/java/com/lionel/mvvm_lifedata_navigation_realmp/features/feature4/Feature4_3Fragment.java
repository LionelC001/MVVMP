package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature43Binding;


public class Feature4_3Fragment extends BaseFragment {


    public Feature4_3Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_3;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navFeature4HostFragment;
    }

    @Override
    protected void initListener() {
        ((FragmentFeature43Binding)dataBinding).btnDone.setOnClickListener(v -> {
            getActivity().finish();
        });
    }
}
