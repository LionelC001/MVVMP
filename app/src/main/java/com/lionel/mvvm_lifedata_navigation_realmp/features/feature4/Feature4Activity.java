package com.lionel.mvvm_lifedata_navigation_realmp.features.feature4;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseActivity;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ActivityFeature4Binding;
import com.lionel.mvvm_lifedata_navigation_realmp.features.MainActivity;

public class Feature4Activity extends BaseActivity {

    private ActivityFeature4Binding dataBinding;
    private NavController navController;

    @Override
    protected void initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(Feature4Activity.this, R.layout.activity_feature4);
    }

    @Override
    protected void initToolbar() {
        dataBinding.layoutToolbar.txtTitle.setText("Feature 4");
    }

    @Override
    protected void initNavigationComponent() {
        navController = Navigation.findNavController(Feature4Activity.this, R.id.navFeature4HostFragment);
    }

    @Override
    protected void initBottomNavigation() {

    }

}
