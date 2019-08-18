package com.lionel.mvvm_lifedata_navigation_realmp.features.feature2;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;
import com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.ApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feature2_1DataSource extends PageKeyedDataSource<Integer, GitHubResponse.ItemsBean> {

    private final String mStrSearchKeyWord;
    private static final int FIRST_PAGE = 1;
    public  static final int PAGE_SIZE = 30;

    public Feature2_1DataSource(String searchKeyWord) {
        this.mStrSearchKeyWord = searchKeyWord;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, GitHubResponse.ItemsBean> callback) {
        ApiManager.getGitHubService().search(mStrSearchKeyWord, FIRST_PAGE).enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                if (response.body() != null) {
                    callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, GitHubResponse.ItemsBean> callback) {
        ApiManager.getGitHubService().search(mStrSearchKeyWord, params.key).enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                if (response.body() != null) {
                    int totalCount = response.body().getTotal_count();
                    Integer nextPage = params.key * PAGE_SIZE < totalCount ? params.key + 1 : null;
                    callback.onResult(response.body().getItems(), nextPage);
                }
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {

            }
        });
    }
}
