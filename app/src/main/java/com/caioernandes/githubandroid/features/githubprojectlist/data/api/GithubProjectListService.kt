package com.caioernandes.githubandroid.features.githubprojectlist.data.api

import com.caioernandes.githubandroid.features.githubprojectlist.data.model.GithubProjectDataResponse
import retrofit2.http.GET

interface GithubProjectListService {

    @GET("search/repositories?q=language:kotlin&sort=starts&page=1")
    suspend fun getGithubProjectList(): GithubProjectDataResponse
}