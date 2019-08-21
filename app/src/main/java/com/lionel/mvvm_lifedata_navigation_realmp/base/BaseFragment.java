package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.content.Context;
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
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ILoadingSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ISwipeBackCallback;
import com.lionel.mvvm_lifedata_navigation_realmp.common.utils.SwipeBackHelper;

public abstract class BaseFragment extends Fragment implements ISwipeBackCallback {

    protected ViewDataBinding baseDataBinding;
    protected NavController navController;
    protected ILoadingSetter mLoadingSetter;

    protected abstract int getLayoutRes();

    protected abstract boolean getIsEnableBack();

    protected abstract void initViewModel();

    protected abstract void initView(ViewDataBinding baseDataBinding);

    protected abstract void initListener();

    protected abstract void initObserve();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mLoadingSetter = (ILoadingSetter) context;
        } catch (ClassCastException e) {
            throw new RuntimeException(context.toString()
                    + " must implement ILoadingSetter");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mLoadingSetter = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseDataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return baseDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViewModel();
        initView(baseDataBinding);
        initListener();
        initObserve();

        initNavigationComponent();
        initBackFunc();
    }

    private void initNavigationComponent() {
        navController = Navigation.findNavController(getActivity(), R.id.navMainHostFragment);
    }


    private void initBackFunc() {
        if (getIsEnableBack()) {
            new SwipeBackHelper().initSwipeBackFunc(getActivity(), baseDataBinding.getRoot(), BaseFragment.this);
        }
    }

    @Override
    public void onSwipeBack() {
        navController.navigateUp();
    }
}
