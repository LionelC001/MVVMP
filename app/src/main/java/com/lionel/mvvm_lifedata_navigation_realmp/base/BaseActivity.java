package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity extends AppCompatActivity {
    private ViewDataBinding dataBinding;

    protected abstract int getLayoutRes();
    protected abstract void initView(ViewDataBinding dataBinding);
    protected abstract void initToolbar();
    protected abstract void initNavigationComponent();
    protected abstract void initBottomNavigation();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutRes());

        initView(dataBinding);
        initToolbar();
        initNavigationComponent();
        initBottomNavigation();
    }
}
