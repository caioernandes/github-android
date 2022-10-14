package com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.remote

import com.caioernandes.githubandroid.features.githubprojectlist.data.api.GithubProjectListService
import com.caioernandes.githubandroid.features.githubprojectlist.data.mapper.toDomain
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData

class GithubProjectListRemoteDataSourceImpl(
    private val service: GithubProjectListService
) : GithubProjectListRemoteDataSource {

    override suspend fun getGithubProjectList(page: Int): GithubProjectData {
        return service.getGithubProjectList(page = page).toDomain()
    }
}