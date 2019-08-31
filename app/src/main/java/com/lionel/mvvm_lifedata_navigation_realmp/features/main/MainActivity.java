package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseActivity;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IBottomBadgeSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IToolbarSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends BaseActivity implements IBottomBadgeSetter, IToolbarSetter {

    private ActivityMainBinding dataBinding;
    private NavController navController;
    private List<View> listImgBadges = new ArrayList<>();

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
                    showToolbar(true);
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

        // make badge
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) dataBinding.bottomNavigationView.getChildAt(0);

        BottomNavigationItemView itemView1 = (BottomNavigationItemView) menuView.getChildAt(0);
        View imgBadge1 = LayoutInflater.from(this).inflate(R.layout.layout_badge, menuView, false);
        itemView1.addView(imgBadge1);

        BottomNavigationItemView itemView2 = (BottomNavigationItemView) menuView.getChildAt(1);
        View imgBadge2 = LayoutInflater.from(this).inflate(R.layout.layout_badge, menuView, false);
        itemView2.addView(imgBadge2);

        BottomNavigationItemView itemView3 = (BottomNavigationItemView) menuView.getChildAt(2);
        View imgBadge3 = LayoutInflater.from(this).inflate(R.layout.layout_badge, menuView, false);
        itemView3.addView(imgBadge3);

        BottomNavigationItemView itemView4 = (BottomNavigationItemView) menuView.getChildAt(3);
        View imgBadge4 = LayoutInflater.from(this).inflate(R.layout.layout_badge, menuView, false);
        itemView4.addView(imgBadge4);

        listImgBadges.add(imgBadge1);
        listImgBadges.add(imgBadge2);
        listImgBadges.add(imgBadge3);
        listImgBadges.add(imgBadge4);
    }

    @Override
    public void refreshBadge(int position, boolean isVisible) {
        listImgBadges.get(position).setVisibility(isVisible ? VISIBLE : GONE);
    }

    @Override
    public void showToolbar(boolean show) {
        dataBinding.layoutToolbar.setNotShowToolbar(!show);
    }
}
