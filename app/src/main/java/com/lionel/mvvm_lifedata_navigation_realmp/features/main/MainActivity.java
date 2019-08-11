package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseActivity;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding dataBinding;
    private NavController navController;

    @Override
    protected void initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
    }

    @Override
    protected void initToolbar() {
        dataBinding.layoutToolbar.txtTitle.setText(R.string.main);
    }

    @Override
    protected void initNavigationComponent() {
        navController = Navigation.findNavController(MainActivity.this, R.id.navMainHostFragment);
    }

    @Override
    protected void initBottomNavigation() {
        NavigationUI.setupWithNavController( dataBinding.bottomNavigationView,navController);
    }
}
