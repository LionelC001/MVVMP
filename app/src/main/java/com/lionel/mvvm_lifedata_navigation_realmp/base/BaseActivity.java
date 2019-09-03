package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.lionel.mvvm_lifedata_navigation_realmp.BR;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ILoadingSetter;

public abstract class BaseActivity extends AppCompatActivity implements ILoadingSetter {
    private ViewDataBinding baseDataBinding;

    protected abstract int getThemeStyle();
    protected abstract int getLayoutRes();
    protected abstract void initView(ViewDataBinding baseDataBinding);
    protected abstract void initToolbar();
    protected abstract void initNavigationComponent();
    protected abstract void initBottomNavigation();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(getThemeStyle());
        super.onCreate(savedInstanceState);
        baseDataBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutRes());

        initView(baseDataBinding);
        initToolbar();
        initNavigationComponent();
        initBottomNavigation();
    }


    @Override
    public void showLoading(boolean isShow){
        baseDataBinding.setVariable(BR.isLoading, isShow);
    }
}
