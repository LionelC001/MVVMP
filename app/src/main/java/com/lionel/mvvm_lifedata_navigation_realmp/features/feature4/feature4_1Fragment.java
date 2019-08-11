package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature41Binding;


public class feature4_1Fragment extends BaseFragment {


    public feature4_1Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature4_1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initBtn();
    }

    private void initBtn() {
        ((FragmentFeature41Binding) dataBinding).btnNext.setOnClickListener(v -> {
            navController.navigate(R.id.action_feature4_1Fragment_to_feature4_2Fragment);
        });
    }
}
