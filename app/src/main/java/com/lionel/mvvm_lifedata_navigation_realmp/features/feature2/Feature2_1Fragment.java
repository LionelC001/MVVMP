package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;


import android.widget.Button;
import android.widget.EditText;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature21Binding;

public class Feature2_1Fragment extends BaseFragment {
    private FragmentFeature21Binding dataBinding;
    private Feature2_1ViewModel mViewModel;
    private EditText mEdtSearch;
    private Button mBtnSearch;
    private Feature2_1Adapter mSearchAdapter;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature2_1;
    }

    @Override
    protected boolean getIsEnableBack() {
        return true;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(Feature2_1ViewModel.class);
    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature21Binding) baseDataBinding;
        mEdtSearch = dataBinding.edtSearch;
        mBtnSearch = dataBinding.btnSearch;
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerViewSearch = dataBinding.recyclerViewSearch;
        mSearchAdapter = new Feature2_1Adapter();
        mRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerViewSearch.setAdapter(mSearchAdapter);
    }


    @Override
    protected void initListener() {
        mBtnSearch.setOnClickListener(v -> {
            mLoadingSetter.showLoading(true);
            mViewModel.performSearch(mEdtSearch.getText().toString());
        });
    }

    @Override
    protected void initObserve() {
        mViewModel.getSearchPagedList().observe(this, itemsBeans -> {
            mLoadingSetter.showLoading(false);
            mSearchAdapter.submitList(itemsBeans);
        });
    }
}
