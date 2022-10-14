package com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.remote

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData

interface GithubProjectListRemoteDataSource {

    suspend fun getGithubProjectList(page: Int): GithubProjectData
}