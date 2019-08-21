package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ILoadingSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ISwipeBackCallback;
import com.lionel.mvvm_lifedata_navigation_realmp.common.utils.SwipeBackHelper;

public abstract class BaseFragment extends Fragment implements ISwipeBackCallback {

    protected NavController navController;
    protected ILoadingSetter mLoadingSetter;

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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNavigationComponent();
    }

    private void initNavigationComponent() {
        navController = Navigation.findNavController(getActivity(), R.id.navMainHostFragment);
    }


    protected void setSwipeBackListener(View view) {
        new SwipeBackHelper().initSwipeBackFunc(getActivity(), view, BaseFragment.this);
    }

    @Override
    public void onSwipeBack() {
        navController.navigateUp();
    }
}
