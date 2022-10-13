package com.caioernandes.githubandroid.features.githubprojectlist.data.api

import com.caioernandes.githubandroid.features.githubprojectlist.data.model.GithubProjectDataResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubProjectListService {

    @GET("search/repositories?q=language:kotlin&sort=starts")
    suspend fun getGithubProjectList(@Query("page") page: Int): GithubProjectDataResponse
}