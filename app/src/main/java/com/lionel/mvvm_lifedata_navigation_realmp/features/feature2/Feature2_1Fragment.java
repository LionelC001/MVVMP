package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature2_1, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initViewModel();
        initListener();
        initRecyclerView();
        initObserve();
    }


    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(Feature2_1ViewModel.class);
    }

    protected void initView() {
        mEdtSearch = dataBinding.edtSearch;
        mBtnSearch = dataBinding.btnSearch;
    }

    private void initListener() {
        mBtnSearch.setOnClickListener(v -> {
            mLoadingSetter.showLoading(true);
            mViewModel.performSearch(mEdtSearch.getText().toString());
        });
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerViewSearch = dataBinding.recyclerViewSearch;
        mSearchAdapter = new Feature2_1Adapter();
        mRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerViewSearch.setAdapter(mSearchAdapter);
    }

    private void initObserve() {
        mViewModel.getSearchPagedList().observe(this, itemsBeans -> {
            Log.d("<>", "initOBSERVE");
            mLoadingSetter.showLoading(false);
            mSearchAdapter.submitList(itemsBeans);
        });
    }
}
