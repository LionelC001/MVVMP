package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.ItemGithubSearchBinding;

public class Feature2_1Adapter extends PagedListAdapter<GitHubResponse.ItemsBean, Feature2_1Adapter.Feature2_1ViewHolder> {


    private static DiffUtil.ItemCallback<GitHubResponse.ItemsBean> diffCallback =
            new DiffUtil.ItemCallback<GitHubResponse.ItemsBean>() {
                @Override
                public boolean areItemsTheSame(GitHubResponse.ItemsBean oldItem, GitHubResponse.ItemsBean newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(GitHubResponse.ItemsBean oldItem, GitHubResponse.ItemsBean newItem) {
                    return oldItem.getDescription().equals(newItem.getDescription());
                }
            };

    public Feature2_1Adapter() {
        super(diffCallback);
    }

    public class Feature2_1ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGithubSearchBinding mDataBinding;

        public Feature2_1ViewHolder(@NonNull ItemGithubSearchBinding dataBinding) {
            super(dataBinding.getRoot());
            this.mDataBinding = dataBinding;
        }

        public ItemGithubSearchBinding getDataBinding() {
            return mDataBinding;
        }
    }

    @NonNull
    @Override
    public Feature2_1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGithubSearchBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_github_search, parent, false);
        return new Feature2_1ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Feature2_1ViewHolder holder, int position) {
        holder.getDataBinding().setItemData(getItem(position));
    }
}
