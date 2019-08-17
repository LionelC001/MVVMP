package com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.service;

import com.lionel.mvvm_lifedata_navigation_realmp.common.model.response.GitHubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubService {

    @GET("search/repositories")
    Call<GitHubResponse> search(@Query("q") String query, @Query("page") int page);
}
