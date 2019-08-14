package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import androidx.databinding.ViewDataBinding;
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
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        this.dataBinding = (ActivityMainBinding) baseDataBinding;
    }

    @Override
    protected void initToolbar() {
        dataBinding.layoutToolbar.txtTitle.setText(R.string.main);
    }

    @Override
    protected void initNavigationComponent() {
        navController = Navigation.findNavController(MainActivity.this, R.id.navMainHostFragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.feature1Fragment:
                case R.id.feature2Fragment:
                case R.id.feature3Fragment:
                case R.id.feature4Fragment:
                    dataBinding.setIsShowBottomNavigation(true);
                    break;
                default:
                    dataBinding.setIsShowBottomNavigation(false);
                    break;
            }
        });
    }

    @Override
    protected void initBottomNavigation() {
        NavigationUI.setupWithNavController(dataBinding.bottomNavigationView, navController);
    }
}
