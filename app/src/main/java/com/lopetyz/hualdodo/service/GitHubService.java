package com.lopetyz.hualdodo.service;

import com.lopetyz.hualdodo.common.network.BaseService;

/**
 * Created by lopetyz on 2017/7/25.
 */

public class GitHubService extends BaseService<GitHubApi> {
    @Override
    protected String getBaseUrl() {
        return "https://api.github.com/";
    }
}
