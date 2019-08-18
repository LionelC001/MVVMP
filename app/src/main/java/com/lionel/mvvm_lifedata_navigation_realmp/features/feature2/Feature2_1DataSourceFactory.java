package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;

public class Feature2_1DataSourceFactory extends DataSource.Factory {
    private final String mSearchKeyWord;
    private MutableLiveData<PageKeyedDataSource<Integer, GitHubResponse.ItemsBean>> liveDataSource = new MutableLiveData<>();

    public Feature2_1DataSourceFactory(String searchKeyWord) {
        this.mSearchKeyWord = searchKeyWord;
    }

    @NonNull
    @Override
    public DataSource<Integer, GitHubResponse.ItemsBean> create() {
        Log.d("<>", "create");
        Feature2_1DataSource dataSource = new Feature2_1DataSource(mSearchKeyWord);
        liveDataSource.postValue(dataSource);
        return dataSource;
    }
}
