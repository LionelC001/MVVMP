package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;


import android.os.Bundle;
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
    private Feature2ViewModel viewModel;
    private EditText mEdtSearch;
    private Button mBtnSearch;
    private RecyclerView mRecyclerViewSearch;

    public Feature2_1Fragment() {
        // Required empty public constructor
    }


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
        viewModel = new ViewModelProvider(this).get(Feature2ViewModel.class);
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
    }

    private void initRecyclerView() {
        mRecyclerViewSearch = dataBinding.recyclerViewSearch;
        Feature2_1Adapter adapter = new Feature2_1Adapter();
        mRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerViewSearch.setAdapter(adapter);
    }


    @Override
    protected void initListener() {
    }
}
