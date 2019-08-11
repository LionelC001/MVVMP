package com.lionel.mvvm_lifedata_navigation_realmp.features;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseActivity;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
    }

    @Override
    protected void initToolbar() {
        dataBinding.layoutToolbar.txtTitle.setText(R.string.main);
    }
}
