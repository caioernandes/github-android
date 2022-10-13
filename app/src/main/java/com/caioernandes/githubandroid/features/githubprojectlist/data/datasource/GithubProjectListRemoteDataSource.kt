package com.caioernandes.githubandroid.features.githubprojectlist.data.datasource

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData

interface GithubProjectListRemoteDataSource {

    suspend fun getGithubProjectList(page: Int): GithubProjectData
}