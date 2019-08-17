package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ItemGithubSearchBinding;

import java.util.ArrayList;
import java.util.List;

public class Feature2_1Adapter extends RecyclerView.Adapter<Feature2_1Adapter.SearchViewHolder> {

    private List<GitHubResponse.ItemsBean> mData = new ArrayList<>();


    public Feature2_1Adapter() {

    }

    public void setData(List<GitHubResponse.ItemsBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private final ItemGithubSearchBinding dataBinding;

        public SearchViewHolder(@NonNull ItemGithubSearchBinding dataBinding) {
            super(dataBinding.getRoot());

            this.dataBinding = dataBinding;
        }

        public ItemGithubSearchBinding getDataBinding() {
            return dataBinding;
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGithubSearchBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_github_search, parent, false);
        return new SearchViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.getDataBinding().setItemData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
