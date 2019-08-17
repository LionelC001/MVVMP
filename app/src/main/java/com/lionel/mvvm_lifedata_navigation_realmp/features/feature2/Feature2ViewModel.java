package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;
import com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.ApiManager;
import com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.service.GithubService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feature2ViewModel extends AndroidViewModel {
    private final GithubService githubService;
    private MutableLiveData<GitHubResponse> mSearchResult = new MutableLiveData<>();

    public Feature2ViewModel(@NonNull Application application) {
        super(application);

        githubService = ApiManager.getInstance().getGitHubService();
    }

    public MutableLiveData<GitHubResponse> getSearchResultLiveData() {
        return mSearchResult;
    }

    public void performSearch(String keyWrod) {
        githubService.search(keyWrod, 1).enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                if (response.body() != null) {
                    Log.d("<>", new Gson().toJson(response.body()));
                    mSearchResult.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {

            }
        });
    }
}
