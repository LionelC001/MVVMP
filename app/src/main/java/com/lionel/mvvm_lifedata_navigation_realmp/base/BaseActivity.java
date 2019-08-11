package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity  extends AppCompatActivity {
    protected abstract void initDataBinding();
    protected abstract void initToolbar();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        initToolbar();
    }
}
