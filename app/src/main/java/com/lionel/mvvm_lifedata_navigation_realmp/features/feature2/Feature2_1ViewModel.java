package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;

import static com.lionel.mvvm_lifedata_navigation_realmp.features.feature2.Feature2_1DataSource.PAGE_SIZE;

public class Feature2_1ViewModel extends AndroidViewModel {
    private LiveData<PagedList<GitHubResponse.ItemsBean>> mSearchPagedList;

    public Feature2_1ViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<PagedList<GitHubResponse.ItemsBean>> getSearchPagedList() {
        return mSearchPagedList;
    }

    public void performSearch(String keyword) {
        Log.d("<>", "perfromSearch");
        Feature2_1DataSourceFactory feature2_1DataSourceFactory = new Feature2_1DataSourceFactory(keyword);
        PagedList.Config pagedListConfig = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(PAGE_SIZE).build();
        mSearchPagedList = new LivePagedListBuilder(feature2_1DataSourceFactory, pagedListConfig).build();
    }
}
