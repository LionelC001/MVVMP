package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
