package com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit;

import android.util.Log;

import com.lionel.mvvm_lifedata_navigation_realmp.common.retrofit.service.GithubService;
import com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiManager {

    private static class GitHubRestClientSingletonHolder {
        private static final GitHubRestClient INSTANCE = new GitHubRestClient();
    }

    private static class GitHubRestClient {
        private final GithubService githubService;
        private GitHubRestClient() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.GIT_HUB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            githubService = retrofit.create(GithubService.class);
        }
    }

    public static GithubService getGitHubService() {
        return GitHubRestClientSingletonHolder.INSTANCE.githubService;
    }
}
