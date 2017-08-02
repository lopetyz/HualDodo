package com.lopetyz.hualdodo.service;

import com.lopetyz.hualdodo.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lopetyz on 2017/7/25.
 */

public interface GitHubApi {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
