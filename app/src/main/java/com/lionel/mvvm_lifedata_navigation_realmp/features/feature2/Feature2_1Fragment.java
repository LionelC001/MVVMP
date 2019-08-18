package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature21Binding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feature2_1Fragment extends BaseFragment {


    private FragmentFeature21Binding dataBinding;
    private Feature2_1ViewModel mViewModel;
    private EditText mEdtSearch;
    private Button mBtnSearch;
    private RecyclerView mRecyclerViewSearch;
    private Feature2_1Adapter mSearchAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature2_1;
    }

    @Override
    protected int getHostFragmentId() {
        return R.id.navMainHostFragment;
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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
        initObserve();
    }

    private void initRecyclerView() {
        mRecyclerViewSearch = dataBinding.recyclerViewSearch;
        mSearchAdapter = new Feature2_1Adapter();
        mRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerViewSearch.setAdapter(mSearchAdapter);
    }

    private void initObserve() {
        mViewModel.getSearchPagedList().observe(this, itemsBeans -> {
            Log.d("<>", "obser");

            mSearchAdapter.submitList(itemsBeans);
        });
    }


    @Override
    protected void initListener() {
        mBtnSearch.setOnClickListener(v -> {
            mViewModel.performSearch(mEdtSearch.getText().toString());
            mSearchAdapter.submitList(null);
        });
    }
}
