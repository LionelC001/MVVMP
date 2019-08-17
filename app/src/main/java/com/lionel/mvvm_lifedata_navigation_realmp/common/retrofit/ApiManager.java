package com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit;

import com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.service.GithubService;
import com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private final GithubService githubService;

    private static class SingletonHolder {
        private static final ApiManager INSTANCE = new ApiManager();

    }

    private ApiManager() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.GIT_HUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubService = retrofit.create(GithubService.class);
    }


    public static ApiManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public GithubService getGitHubService() {
        return githubService;
    }
}
