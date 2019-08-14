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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lionel.mvvm_lifedata_navigation_realmp.features.feature2.Feature2ViewModel;

public abstract class BaseFragment extends Fragment {

    protected ViewDataBinding baseDataBinding;
    protected NavController navController;
    private Feature2ViewModel baseViewModel;

    protected abstract int getLayoutRes();

    protected abstract int getHostFragmentId();

    protected abstract void initView(ViewDataBinding baseDataBinding);

    protected abstract void initListener();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseDataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        baseViewModel = new ViewModelProvider(getActivity()).get(Feature2ViewModel.class);
        return baseDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initNavigationComponent();
        initView(baseDataBinding);
        initListener();
    }


    private void initNavigationComponent() {
        navController = Navigation.findNavController(getActivity(), getHostFragmentId());
    }
}
