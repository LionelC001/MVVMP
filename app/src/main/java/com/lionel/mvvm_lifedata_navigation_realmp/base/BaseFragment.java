package com.lionel.mvvm_lifedata_navigation_realmp.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ILoadingSetter;

public abstract class BaseFragment extends Fragment {

    protected NavController navController;
    protected ILoadingSetter mLoadingSetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ILoadingSetter) {
            mLoadingSetter = (ILoadingSetter) context;
        } else {
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
}
