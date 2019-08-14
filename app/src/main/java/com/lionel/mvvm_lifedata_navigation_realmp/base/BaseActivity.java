package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity extends AppCompatActivity {
    private ViewDataBinding baseDataBinding;

    protected abstract int getLayoutRes();
    protected abstract void initView(ViewDataBinding baseDataBinding);
    protected abstract void initToolbar();
    protected abstract void initNavigationComponent();
    protected abstract void initBottomNavigation();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseDataBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutRes());

        initView(baseDataBinding);
        initToolbar();
        initNavigationComponent();
        initBottomNavigation();
    }
}
