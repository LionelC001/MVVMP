package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;

import static com.lionel.mvvm_lifedata_navigation_realmp.features.feature2.Feature2_1DataSourceFactory.PAGE_SIZE;

public class Feature2_1ViewModel extends AndroidViewModel {
    private final MutableLiveData<String> keywordLiveData = new MutableLiveData<>();
    private final Feature2_1Repo mRepo;
    private final LiveData<PagedList<GitHubResponse.ItemsBean>> mSearchPagedList = Transformations.switchMap(keywordLiveData, this::getPagedList);


    public Feature2_1ViewModel(@NonNull Application application) {
        super(application);
        mRepo = new Feature2_1Repo();
    }

    public LiveData<PagedList<GitHubResponse.ItemsBean>> getSearchPagedList() {
        return mSearchPagedList;
    }

    public void performSearch(String keyword) {
        keywordLiveData.setValue(keyword);
    }

    private LiveData<PagedList<GitHubResponse.ItemsBean>> getPagedList(String input) {
        return mRepo.getPagedList(input);
    }
}
