package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lionel.mvvm_lifedata_navigation_realmp.R;

public abstract class BaseFragment extends Fragment {

    protected ViewDataBinding dataBinding;
    protected NavController navController;

    protected abstract int getLayoutRes();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initNavigationComponent();
    }

    private void initNavigationComponent() {
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    }
}
