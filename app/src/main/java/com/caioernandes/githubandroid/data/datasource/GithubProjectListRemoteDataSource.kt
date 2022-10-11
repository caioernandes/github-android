package com.caioernandes.githubandroid.data.datasource

import com.caioernandes.githubandroid.domain.model.GithubProjectData

interface GithubProjectListRemoteDataSource {

    suspend fun getGithubProjectList(): GithubProjectData
}