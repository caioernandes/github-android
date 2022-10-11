package com.caioernandes.githubandroid.data.api

import com.caioernandes.githubandroid.data.model.GithubProjectDataResponse
import retrofit2.http.GET

interface GithubProjectListService {

    @GET("search/repositories?q=language:kotlin&sort=starts&page=1")
    suspend fun getGithubProjectList(): GithubProjectDataResponse
}