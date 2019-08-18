package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;

import static com.lionel.mvvm_lifedata_navigation_realmp.features.feature2.Feature2_1DataSourceFactory.PAGE_SIZE;

public class Feature2_1Repo {


    public LiveData<PagedList<GitHubResponse.ItemsBean>> getPagedList(String input) {
        Feature2_1DataSourceFactory feature2_1DataSourceFactory = new Feature2_1DataSourceFactory(input);
        PagedList.Config pagedListConfig = new PagedList.Config.Builder().setPageSize(PAGE_SIZE).build();
        LiveData<PagedList<GitHubResponse.ItemsBean>> pagedListLiveData = new LivePagedListBuilder(feature2_1DataSourceFactory, pagedListConfig).build();
        return pagedListLiveData;
    }
}
